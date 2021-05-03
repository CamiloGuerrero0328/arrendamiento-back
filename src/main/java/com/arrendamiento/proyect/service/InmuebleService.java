package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.Inmueble;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface InmuebleService extends GenericService<Inmueble, Integer> {
	
	public List<Inmueble> findByIdCliente(Integer idCliente) throws Exception;
	public List<Inmueble> findByIdInmueble(int idCliente) throws Exception;
	public List<Inmueble> findInmueblesAplicados(Integer idCliente) throws Exception;
}
