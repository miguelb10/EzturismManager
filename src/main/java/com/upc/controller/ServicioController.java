package com.upc.controller;

import com.upc.entity.DetallePaquete;
import com.upc.entity.Paquete;
import com.upc.entity.Servicio;
import com.upc.exception.ModeloNotFoundException;
import com.upc.service.PaqueteService;
import com.upc.service.ServicioService;
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
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;
    
    @Autowired
    private PaqueteService paqueteService;

    @GetMapping
    public ResponseEntity<List<Servicio>> listar(){

        List<Servicio> servicios = new ArrayList<>();
        servicios = servicioService.listar();

        return new ResponseEntity<List<Servicio>>(servicios, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
	public Resource<Servicio> listarId(@PathVariable("id") Integer id) {
		Optional<Servicio> serv = servicioService.listarId(id);
		if (!serv.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		Resource<Servicio> resource = new Resource<Servicio>(serv.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("Consulta-resource"));
		
		return resource;
	}
    
    @GetMapping(value = "/paquete/{id}")
   	public ResponseEntity<List<DetallePaquete>> listarServicosPaqueteId(@PathVariable("id") Integer id) {
    	
    	Paquete paq = paqueteService.findById(id);
    	
   		List<DetallePaquete> detPaq = servicioService.findByPaquete(paq);
   		   		
   		return new ResponseEntity<List<DetallePaquete>>(detPaq, HttpStatus.OK);
   	}

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Servicio servicio) {
        Servicio serv = new Servicio();
        serv = servicioService.registrar(servicio);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(serv.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Servicio servicio) {		
    	servicioService.modificar(servicio);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public void eliminar(@PathVariable Integer id) {
		Optional<Servicio> cli = servicioService.listarId(id);
		if (!cli.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			servicioService.eliminar(id);
		}
	}

}
