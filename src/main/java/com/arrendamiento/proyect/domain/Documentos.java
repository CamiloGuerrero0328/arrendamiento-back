package com.arrendamiento.proyect.domain;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "documentos", schema = "public")
public class Documentos implements java.io.Serializable {
    @NotNull
    private Integer idDocumentos;
    @NotNull
    private Cliente cliente;
    private String cartaLaboral;
    private String cedulaCiudadania;
    private String codeudor;
    private Date fechaIngreso;
    private String rut;
    private String solicitudArrendamiento;

    public Documentos() {
    }

    public Documentos(Integer idDocumentos, String cartaLaboral,
        String cedulaCiudadania, Cliente cliente, String codeudor,
        Date fechaIngreso, String rut, String solicitudArrendamiento) {
        this.idDocumentos = idDocumentos;
        this.cliente = cliente;
        this.cartaLaboral = cartaLaboral;
        this.cedulaCiudadania = cedulaCiudadania;
        this.codeudor = codeudor;
        this.fechaIngreso = fechaIngreso;
        this.rut = rut;
        this.solicitudArrendamiento = solicitudArrendamiento;
    }

    @Id
    @Column(name = "id_documentos", unique = true, nullable = false)
    public Integer getIdDocumentos() {
        return this.idDocumentos;
    }

    public void setIdDocumentos(Integer idDocumentos) {
        this.idDocumentos = idDocumentos;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(name = "carta_laboral")
    public String getCartaLaboral() {
        return this.cartaLaboral;
    }

    public void setCartaLaboral(String cartaLaboral) {
        this.cartaLaboral = cartaLaboral;
    }

    @Column(name = "cedula_ciudadania")
    public String getCedulaCiudadania() {
        return this.cedulaCiudadania;
    }

    public void setCedulaCiudadania(String cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }

    @Column(name = "codeudor")
    public String getCodeudor() {
        return this.codeudor;
    }

    public void setCodeudor(String codeudor) {
        this.codeudor = codeudor;
    }

    @Column(name = "fecha_ingreso")
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Column(name = "rut")
    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Column(name = "solicitud_arrendamiento")
    public String getSolicitudArrendamiento() {
        return this.solicitudArrendamiento;
    }

    public void setSolicitudArrendamiento(String solicitudArrendamiento) {
        this.solicitudArrendamiento = solicitudArrendamiento;
    }
}
