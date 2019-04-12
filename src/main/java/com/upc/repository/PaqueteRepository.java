package com.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.entity.Paquete;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {

}