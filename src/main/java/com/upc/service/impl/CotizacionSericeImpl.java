package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Cotizacion;
import com.upc.repository.CotizacionRepository;
import com.upc.service.CotizacionService;

@Service
public class CotizacionSericeImpl implements CotizacionService{

	@Autowired
	private CotizacionRepository cotizacionRepository;
	
	@Override
	public Cotizacion registrar(Cotizacion cotizacion) {
		return cotizacionRepository.save(cotizacion);
	}

	@Override
	public Cotizacion modificar(Cotizacion cotizacion) {
		return cotizacionRepository.save(cotizacion);
	}

	@Override
	public void eliminar(int id) {
		cotizacionRepository.deleteById(id);
	}

	@Override
	public Optional<Cotizacion> listarId(int id) {
		return cotizacionRepository.findById(id);
	}

	@Override
	public List<Cotizacion> listar() {
		return cotizacionRepository.findAll();
	}

}
