package com.upc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DetallePaquetePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "paquete_id", nullable = false)
	private Paquete paquete;
	
	@ManyToOne
	@JoinColumn(name = "servicio_id", nullable = false)
	private Servicio servicio;
}
