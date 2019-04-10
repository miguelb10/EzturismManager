package com.upc.service.impl;

import com.upc.entity.Proveedor;
import com.upc.repository.ProveedorRepository;
import com.upc.service.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor registrar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor modificar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminar(int id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public Optional<Proveedor> listarId(int id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }
}
