package com.upc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Paquete")
public class Paquete {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;	
	private String descripcion;
	private String adicionales;
	private float precio;
	@OneToMany(mappedBy = "paquete", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetallePaquete> detallePaquete;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAdicionales() {
		return adicionales;
	}
	public void setAdicionales(String adicionales) {
		this.adicionales = adicionales;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public List<DetallePaquete> getDetallePaquete() {
		return detallePaquete;
	}
	public void setDetallePaquete(List<DetallePaquete> detallePaquete) {
		this.detallePaquete = detallePaquete;
	}	
}
