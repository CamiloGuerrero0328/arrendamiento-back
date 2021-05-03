package com.arrendamiento.proyect.domain;


import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "reporte", schema = "public")
public class Reporte implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_reporte", unique = true, nullable = false)
    @NotNull
    private Long idReporte;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    @NotNull
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inmueble")
    @NotNull
    private Inmueble inmueble;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
	public Long getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Long idReporte) {
		this.idReporte = idReporte;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Inmueble getInmueble() {
		return inmueble;
	}
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
