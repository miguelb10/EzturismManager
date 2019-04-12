package com.upc.service.impl;

import com.upc.entity.ListaPasajeros;
import com.upc.repository.ListaPasajerosRepository;
import com.upc.service.ListaPasajerosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaPasajerosServiceImpl implements ListaPasajerosService {

    @Autowired
    private ListaPasajerosRepository listaPasajerosRepository;

    @Override
    public ListaPasajeros registrar(ListaPasajeros listaPasajeros) {
        return listaPasajerosRepository.save(listaPasajeros);
    }

    @Override
    public ListaPasajeros modificar(ListaPasajeros listaPasajeros) {
        return listaPasajerosRepository.save(listaPasajeros);
    }

    @Override
    public void eliminar(int id) {
        listaPasajerosRepository.deleteById(id);
    }

    @Override
    public Optional<ListaPasajeros> listarId(int id) {
        return listaPasajerosRepository.findById(id);
    }

    @Override
    public List<ListaPasajeros> listar() {
        return listaPasajerosRepository.findAll();
    }
}
