package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.TipoDocumento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   TipoDocumentoRepository.
*
*/
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
