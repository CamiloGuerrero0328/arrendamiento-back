package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.Proceso;
import com.arrendamiento.proyect.domain.Reporte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ReporteRepository extends JpaRepository<Reporte, Long> {
	
	@Query("SELECT a FROM Reporte a WHERE a.inmueble.idInmueble = :idInmueble")
    public List<Reporte> findByIdInmueble(@Param("idInmueble") Integer id);
}
