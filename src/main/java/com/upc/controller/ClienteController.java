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
import com.upc.entity.Cliente;
import com.upc.exception.ModeloNotFoundException;
import com.upc.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>>  listar(){
		
		List<Cliente> clientes = new ArrayList<>();
		clientes = clienteService.listar();
		
		return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}")
	public Resource<Cliente> listarId(@PathVariable("id") Integer id) {
		Optional<Cliente> cli = clienteService.listarId(id);
		if (!cli.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		Resource<Cliente> resource = new Resource<Cliente>(cli.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("Consulta-resource"));
		
		return resource;
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Cliente cliente) {
		Cliente cli = new Cliente();
		cli = clienteService.registrar(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Cliente cliente) {		
		clienteService.modificar(cliente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public void eliminar(@PathVariable Integer id) {
		Optional<Cliente> cli = clienteService.listarId(id);
		if (!cli.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			clienteService.eliminar(id);
		}
	}

}
