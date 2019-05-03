package com.upc.service;

import com.upc.dto.PaqueteListaServicioDTO;
import com.upc.entity.Paquete;

public interface PaqueteService extends CrudService<Paquete>  {
	Paquete registrar(PaqueteListaServicioDTO paqueteDTO);
}
