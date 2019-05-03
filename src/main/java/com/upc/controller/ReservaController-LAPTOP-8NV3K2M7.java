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

import com.upc.entity.Reserva;
import com.upc.exception.ModeloNotFoundException;
import com.upc.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@GetMapping
	public ResponseEntity<List<Reserva>>  listar(){
		
		List<Reserva> reservas = new ArrayList<>();
		reservas = reservaService.listar();
		
		return new ResponseEntity<List<Reserva>>(reservas,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}")
	public Resource<Reserva> listarId(@PathVariable("id") Integer id) {
		Optional<Reserva> res = reservaService.listarId(id);
		if (!res.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		Resource<Reserva> resource = new Resource<Reserva>(res.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("Consulta-resource"));
		
		return resource;
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Reserva reserva) {
		Reserva res = new Reserva();
		res = reservaService.registrar(reserva);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(res.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Reserva reserva) {		
		reservaService.modificar(reserva);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public void eliminar(@PathVariable Integer id) {
		Optional<Reserva> res = reservaService.listarId(id);
		if (!res.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			reservaService.eliminar(id);
		}
	}
}
