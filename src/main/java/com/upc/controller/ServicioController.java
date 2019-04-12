package com.upc.controller;

import com.upc.entity.Servicio;
import com.upc.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> listar(){

        List<Servicio> servicios = new ArrayList<>();
        servicios = servicioService.listar();

        return new ResponseEntity<List<Servicio>>(servicios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Servicio servicio) {
        Servicio serv = new Servicio();
        serv = servicioService.registrar(servicio);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(serv.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
