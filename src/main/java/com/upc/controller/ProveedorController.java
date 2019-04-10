package com.upc.controller;

import com.upc.entity.Proveedor;
import com.upc.service.ProveedorService;
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

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Proveedor proveedor) {
        Proveedor prov = new Proveedor();
        prov = proveedorService.registrar(proveedor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prov.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
