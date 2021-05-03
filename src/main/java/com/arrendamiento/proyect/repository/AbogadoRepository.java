package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.Abogado;
import com.arrendamiento.proyect.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;


/**
* Interface for   AbogadoRepository.
*
*/
public interface AbogadoRepository extends JpaRepository<Abogado, Integer> {
	
	@Query("SELECT u FROM Abogado u WHERE u.usuario.idUsuario =:idUsuario")
	public Abogado findAbogadoByIdUser(@Param("idUsuario") int id);
}
