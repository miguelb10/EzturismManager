package com.upc.service.impl;

import com.upc.entity.Pasajero;
import com.upc.repository.PasajeroRepository;
import com.upc.service.PasajeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroServiceImpl implements PasajeroService {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Override
    public Pasajero registrar(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    @Override
    public Pasajero modificar(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    @Override
    public void eliminar(int id) {
        pasajeroRepository.deleteById(id);
    }

    @Override
    public Optional<Pasajero> listarId(int id) {
        return pasajeroRepository.findById(id);
    }

    @Override
    public List<Pasajero> listar() {
        return pasajeroRepository.findAll();
    }
}
