package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.Inmueble;
import com.arrendamiento.proyect.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


/**
* Interface for   InmuebleRepository.
*
*/
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer> {
	
	@Query("SELECT a FROM Inmueble a WHERE a.cliente.idCliente = :idCliente")
    public List<Inmueble> findByIdCliente(@Param("idCliente") Integer id);
	
	@Query("SELECT a FROM Inmueble a WHERE a.idInmueble = :idInmueble")
    public List<Inmueble> findByIdInmueble(@Param("idInmueble") int id);
	
	@Query("SELECT i FROM Proceso p, Inmueble i, Cliente cl WHERE p.inmueble = i.idInmueble "
			+ "AND p.cliente = cl.idCliente AND p.estado = true AND p.pagado = true "
			+ "AND p.cliente.idCliente = :idCliente")
	public List<Inmueble> findInmueblesAplicados(@Param("idCliente") Integer id);
	
}
