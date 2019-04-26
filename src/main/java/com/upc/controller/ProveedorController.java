package com.upc.controller;

import com.upc.entity.Proveedor;
import com.upc.exception.ModeloNotFoundException;
import com.upc.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>>  listar(){

        List<Proveedor> proveedores = new ArrayList<>();
        proveedores = proveedorService.listar();

        return new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
	public Resource<Proveedor> listarId(@PathVariable("id") Integer id) {
		Optional<Proveedor> prov = proveedorService.listarId(id);
		if (!prov.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		Resource<Proveedor> resource = new Resource<Proveedor>(prov.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("Consulta-resource"));
		
		return resource;
	}

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Proveedor proveedor) {
        Proveedor prov = new Proveedor();
        prov = proveedorService.registrar(proveedor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prov.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Proveedor proveedor) {		
    	proveedorService.modificar(proveedor);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public void eliminar(@PathVariable Integer id) {
		Optional<Proveedor> cli = proveedorService.listarId(id);
		if (!cli.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			proveedorService.eliminar(id);
		}
	}

}
