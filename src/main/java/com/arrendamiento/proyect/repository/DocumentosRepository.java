package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.Cliente;
import com.arrendamiento.proyect.domain.Documentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


/**
* Interface for   DocumentosRepository.
*
*/
public interface DocumentosRepository extends JpaRepository<Documentos, Integer> {
	
	@Query("SELECT u FROM Documentos u WHERE u.cliente.idCliente =:idCliente")
	public List<Documentos> findByIdCliente(@Param("idCliente") int id);
}
