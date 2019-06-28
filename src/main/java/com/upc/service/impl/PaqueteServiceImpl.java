package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Paquete;
import com.upc.repository.PaqueteRepository;
import com.upc.service.PaqueteService;

@Service
public class PaqueteServiceImpl implements PaqueteService {

	@Autowired
	private PaqueteRepository paqueteRepository;

	//@Autowired
	//private DetallePaqueteRepository detPaqueteRepository;

	@Override
	public Paquete registrar(Paquete paquete) {
		return paqueteRepository.save(paquete);
	}

	@Override
	public Paquete modificar(Paquete paquete) {
		return paqueteRepository.save(paquete);
	}

	@Override
	public void eliminar(int id) {
		paqueteRepository.deleteById(id);
	}

	@Override
	public Optional<Paquete> listarId(int id) {
		return paqueteRepository.findById(id);
	}

	@Override
	public List<Paquete> listar() {
		return paqueteRepository.findAll();
	}

	@Override
	public Paquete findById(int id) {
		return paqueteRepository.getOne(id);
	}

	/*@Transactional
	@Override
	public Paquete registrar(PaqueteListaServicioDTO paqueteDTO) {
				
		paqueteRepository.save(paqueteDTO.getPaquete());
		
		paqueteDTO.getLstServicio()
		.forEach(servicio->detPaqueteRepository.registrar
				(paqueteDTO.getPaquete().getId(),servicio.getId()));
		
		return paqueteDTO.getPaquete();
	}*/

}
