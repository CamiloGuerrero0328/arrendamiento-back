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
public class TransactionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcion;
    @NotNull
    private Date fecha;
    @NotNull
    private Long idTransaction;
    @NotNull
    private Double monto;
    private Long idCliente_Cliente;
    private Long idInmueble_Inmueble;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
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
