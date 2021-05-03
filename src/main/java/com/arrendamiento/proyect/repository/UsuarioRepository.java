package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;


/**
* Interface for   UsuarioRepository.
*
*/
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query("SELECT u FROM Usuario u WHERE u.correoElectronico =:correoElectronico")
	public Usuario findByEmail(@Param("correoElectronico") String email);
}
