package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.upc.entity.Reserva;
import com.upc.repository.ReservaRepository;
import com.upc.service.ReservaService;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public Reserva registrar(Reserva t) {
		return reservaRepository.save(t);
	}

	@Override
	public Reserva modificar(Reserva t) {
		return reservaRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		reservaRepository.deleteById(id);;
	}

	@Override
	public Optional<Reserva> listarId(int id) {
		return reservaRepository.findById(id);
	}

	@Override
	public List<Reserva> listar() {
		return reservaRepository.findAll();
	}

}
