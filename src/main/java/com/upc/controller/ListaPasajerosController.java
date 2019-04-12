package com.upc.controller;

import com.upc.entity.ListaPasajeros;
import com.upc.service.ListaPasajerosService;
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
@RequestMapping(name="/listapasajeros")
public class ListaPasajerosController {

    @Autowired
    private ListaPasajerosService listaPasajerosService;

    @GetMapping
    public ResponseEntity<List<ListaPasajeros>> listar(){

        List<ListaPasajeros> listaPasajeros = new ArrayList<>();
        listaPasajeros = listaPasajerosService.listar();

        return new ResponseEntity<List<ListaPasajeros>>(listaPasajeros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody ListaPasajeros listaPasajeros) {
        ListaPasajeros listPas = new ListaPasajeros();
        listPas = listaPasajerosService.registrar(listaPasajeros);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(listPas.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
