package com.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.entity.Cotizacion;

@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer> {

}