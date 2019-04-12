package com.upc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
