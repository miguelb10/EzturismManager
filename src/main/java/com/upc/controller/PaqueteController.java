package com.upc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upc.entity.Paquete;
import com.upc.exception.ModeloNotFoundException;
import com.upc.service.PaqueteService;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

	@Autowired
	private PaqueteService paqueteService;
	

	@GetMapping
	public ResponseEntity<List<Paquete>> listar() {

		List<Paquete> paquetes = new ArrayList<>();
		paquetes = paqueteService.listar();

		return new ResponseEntity<List<Paquete>>(paquetes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Paquete> listarId(@PathVariable("id") Integer id) {
		Optional<Paquete> paquete = paqueteService.listarId(id);
		if (!paquete.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}

		return new ResponseEntity<Paquete>(paquete.get(), HttpStatus.OK);
	}

	/*
	@PostMapping
	public ResponseEntity<Paquete> registrar(@Valid @RequestBody PaqueteListaServicioDTO paqueteDTO) {
		Paquete paquete = new Paquete();
		paquete = paqueteService.registrar(paqueteDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paquete.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}*/
	
	@PostMapping
	public ResponseEntity<Paquete> registrar(@Valid @RequestBody Paquete paquete) {
		Paquete paq = new Paquete();
		paq = paqueteService.registrar(paquete);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paq.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Paquete> actualizar(@Valid @RequestBody Paquete paquete) {
		paqueteService.modificar(paquete);
		return new ResponseEntity<Paquete>(HttpStatus.OK);
	}


	@DeleteMapping
	public void eliminar(@PathVariable Integer id) {
		Optional<Paquete> paq = paqueteService.listarId(id);
		if (!paq.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			paqueteService.eliminar(id);
		}
	}

}
