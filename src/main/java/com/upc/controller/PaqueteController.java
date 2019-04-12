package com.upc.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
/*
	@GetMapping(value = "/{id}")
	public Resource<Paquete> listarId(@PathVariable("id") Integer id) {
		Optional<Paquete> paq = paqueteService.listarId(id);
		if (!paq.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		Resource<Paquete> resource = new Resource<Paquete>(paq.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("Consulta-resource"));
		
		return resource;
	}*/
    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Paquete paquete) {
        Paquete paq = new Paquete();
        paq = paqueteService.registrar(paquete);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paq.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
	
    @PutMapping
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Paquete paquete) {		
		paqueteService.modificar(paquete);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	@DeleteMapping
	public void eliminar(@PathVariable Integer id) {
		Optional<Paquete> cli = paqueteService.listarId(id);
		if (!cli.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			paqueteService.eliminar(id);
		}
	}

}
