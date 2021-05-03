package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.Inmueble;
import com.arrendamiento.proyect.domain.Proceso;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ProcesoService extends GenericService<Proceso, Integer> {
	
	public List<Proceso> findByIdCliente(Integer idCliente) throws Exception;
		
}
