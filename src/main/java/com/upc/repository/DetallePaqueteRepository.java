package com.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.upc.entity.DetallePaquete;

@Repository
public interface DetallePaqueteRepository extends JpaRepository<DetallePaquete,	Integer>{
	@Modifying
	@Query(value="INSERT INTO DetallePaquete(paquete_id,servicio_id) "
			+ "VALUES(:paqueteId,:servicioId) ",nativeQuery=true)
	Integer registrar (@Param("paqueteId") Integer paqueteId,
			@Param("servicioId") Integer servicioId);
	
}
