package com.upc.dto;

import java.util.List;

import com.upc.entity.Paquete;
import com.upc.entity.Servicio;

public class PaqueteListaServicioDTO {
	
	private Paquete paquete;
	private List<Servicio> lstServicio;
	
	public Paquete getPaquete() {
		return paquete;
	}
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	public List<Servicio> getLstServicio() {
		return lstServicio;
	}
	public void setLstServicio(List<Servicio> lstServicio) {
		this.lstServicio = lstServicio;
	}
}
