package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


/**
* Interface for   ClienteRepository.
*
*/
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("SELECT u FROM Cliente u WHERE u.tipoCliente.idTipoCliente =:idTipoCliente")
	public List<Cliente> findByTipoCliente(@Param("idTipoCliente") int id);
	
	@Query("SELECT u FROM Cliente u WHERE u.usuario.idUsuario =:idUsuario")
	public Cliente findClientByIdUser(@Param("idUsuario") int id);
}
