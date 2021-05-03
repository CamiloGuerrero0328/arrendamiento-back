package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.Abogado;
import com.arrendamiento.proyect.domain.Cliente;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface AbogadoService extends GenericService<Abogado, Integer> {
	
	public Abogado findAbogadoByIdUser(int id) throws Exception;
}
