package com.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

}
