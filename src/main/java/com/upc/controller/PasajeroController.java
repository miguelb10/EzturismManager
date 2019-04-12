package com.upc.controller;

import com.upc.entity.Pasajero;
import com.upc.service.PasajeroService;
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
@RequestMapping(name="/pasajeros")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping
    public ResponseEntity<List<Pasajero>> listar(){

        List<Pasajero> pasajeros = new ArrayList<>();
        pasajeros = pasajeroService.listar();

        return new ResponseEntity<List<Pasajero>>(pasajeros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Pasajero pasajero) {
        Pasajero pas = new Pasajero();
        pas = pasajeroService.registrar(pasajero);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pas.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
