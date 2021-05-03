package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.TipoUsuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   TipoUsuarioRepository.
*
*/
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
