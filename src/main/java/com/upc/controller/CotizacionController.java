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

import com.upc.entity.Cotizacion;
import com.upc.service.CotizacionService;

@RestController
@RequestMapping("/cotizacion")
public class CotizacionController {

	@Autowired
	private CotizacionService cotizacionService;
	
	@GetMapping
    public ResponseEntity<List<Cotizacion>> listar(){

        List<Cotizacion> cotizaciones = new ArrayList<>();
        cotizaciones = cotizacionService.listar();

        return new ResponseEntity<List<Cotizacion>>(cotizaciones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Cotizacion cotizacion) {
        Cotizacion cot = new Cotizacion();
        cot = cotizacionService.registrar(cotizacion);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cot.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
