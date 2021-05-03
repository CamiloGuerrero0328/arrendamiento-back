package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.Proceso;
import com.arrendamiento.proyect.domain.Reporte;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ReporteService extends GenericService<Reporte, Long> {
	
	public List<Reporte> findByIdInmueble(Integer idInmueble) throws Exception;
}
