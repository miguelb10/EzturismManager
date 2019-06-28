package com.upc.service;

import java.util.List;

import com.upc.entity.DetallePaquete;
import com.upc.entity.Paquete;
import com.upc.entity.Servicio;

public interface ServicioService extends CrudService<Servicio> {
	
	List<DetallePaquete> findByPaquete(Paquete paquete);
}
