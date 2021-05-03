package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.Usuario;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface UsuarioService extends GenericService<Usuario, Integer> {
	
	public Usuario findByEmail(String correoElectronico) throws Exception;
	
}
