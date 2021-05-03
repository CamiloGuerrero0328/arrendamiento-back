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
@Table(name = "transaction", schema = "public")
public class Transaction implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_transaction", unique = true, nullable = false)
    @NotNull
    private Long idTransaction;
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
    @NotNull
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @NotNull
    @Column(name = "monto", nullable = false)
    private Double monto;
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
