package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.Inmueble;
import com.arrendamiento.proyect.domain.Proceso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


/**
* Interface for   ProcesoRepository.
*
*/
public interface ProcesoRepository extends JpaRepository<Proceso, Integer> {
	
	@Query("SELECT a FROM Proceso a WHERE a.cliente.idCliente = :idCliente")
    public List<Proceso> findByIdCliente(@Param("idCliente") Integer id);
	
	
}
