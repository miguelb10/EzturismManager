package com.upc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upc.entity.Paquete;
import com.upc.service.PaqueteService;

@RestController
@RequestMapping(name="/paquete")
public class PaqueteController {
	
	@Autowired
	private PaqueteService paqueteService;
	
	@GetMapping
    public ResponseEntity<List<Paquete>> listar(){

        List<Paquete> paquetes = new ArrayList<>();
        paquetes = paqueteService.listar();

        return new ResponseEntity<List<Paquete>>(paquetes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Paquete paquete) {
        Paquete paq = new Paquete();
        paq = paqueteService.registrar(paquete);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paq.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
