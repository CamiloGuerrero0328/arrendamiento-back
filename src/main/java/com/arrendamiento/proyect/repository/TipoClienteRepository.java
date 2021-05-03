package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.TipoCliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   TipoClienteRepository.
*
*/
public interface TipoClienteRepository extends JpaRepository<TipoCliente, Integer> {
}
