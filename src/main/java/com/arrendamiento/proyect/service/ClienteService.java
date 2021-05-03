package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.Cliente;
import com.arrendamiento.proyect.domain.Inmueble;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ClienteService extends GenericService<Cliente, Integer> {
	
	public List<Cliente> findByTipoCliente(int id) throws Exception;
	
	public Cliente findClientByIdUser(int id) throws Exception;
	
}
