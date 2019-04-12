package com.upc.service.impl;

import com.upc.entity.Servicio;
import com.upc.repository.ServicioRepository;
import com.upc.service.ServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public Servicio registrar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio modificar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void eliminar(int id) {
        servicioRepository.deleteById(id);
    }

    @Override
    public Optional<Servicio> listarId(int id) {
        return servicioRepository.findById(id);
    }

    @Override
    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }
}
