package com.arrendamiento.proyect.dto;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public class ReporteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcion;
    private Boolean estado;
    @NotNull
    private Long idReporte;
    private Long idCliente_Cliente;
    private Long idInmueble_Inmueble;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Long getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Long idReporte) {
		this.idReporte = idReporte;
	}
	public Long getIdCliente_Cliente() {
		return idCliente_Cliente;
	}
	public void setIdCliente_Cliente(Long idCliente_Cliente) {
		this.idCliente_Cliente = idCliente_Cliente;
	}
	public Long getIdInmueble_Inmueble() {
		return idInmueble_Inmueble;
	}
	public void setIdInmueble_Inmueble(Long idInmueble_Inmueble) {
		this.idInmueble_Inmueble = idInmueble_Inmueble;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
