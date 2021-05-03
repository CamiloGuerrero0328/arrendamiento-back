package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.Documentos;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface DocumentosService extends GenericService<Documentos, Integer> {
	
	public List<Documentos> findByIdCliente(int id) throws Exception;
}
