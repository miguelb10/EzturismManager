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
}
