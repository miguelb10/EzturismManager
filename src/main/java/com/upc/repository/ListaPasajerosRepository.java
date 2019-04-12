package com.upc.repository;

import com.upc.entity.ListaPasajeros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaPasajerosRepository extends JpaRepository<ListaPasajeros,Integer> {
}
