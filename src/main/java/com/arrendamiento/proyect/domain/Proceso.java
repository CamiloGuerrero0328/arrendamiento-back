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
@Table(name = "proceso", schema = "public")
public class Proceso implements java.io.Serializable {
    @NotNull
    private Integer idProceso;
    private Abogado abogado;
    @NotNull
    private Cliente cliente;
    private Inmueble inmueble;
    private Boolean estado;
    private Date fechaProceso;
    private String nombreProceso;
    private String info;
    private Boolean pagado;

    public Proceso() {
    }

    public Proceso(Integer idProceso, Abogado abogado, Cliente cliente,
        Inmueble inmueble, Boolean estado, Date fechaProceso, String nombreProceso, String info,
        Boolean pagado) {
        this.idProceso = idProceso;
        this.abogado = abogado;
        this.cliente = cliente;
        this.inmueble = inmueble;
        this.estado = estado;
        this.fechaProceso = fechaProceso;
        this.nombreProceso = nombreProceso;
        this.info = info;
    }

    @Id
    @Column(name = "id_proceso", unique = true, nullable = false)
    public Integer getIdProceso() {
        return this.idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_abogado")
    public Abogado getAbogado() {
        return this.abogado;
    }

    public void setAbogado(Abogado abogado) {
        this.abogado = abogado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    ///////
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inmueble")
    public Inmueble getInmueble() {
        return this.inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
    //////

    @Column(name = "estado")
    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Column(name = "fecha_proceso")
    public Date getFechaProceso() {
        return this.fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    @Column(name = "nombre_proceso")
    public String getNombreProceso() {
        return this.nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }
    
    @Column(name = "pagado")
    public Boolean getPagado() {
        return this.pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }
    
    @Column(name = "info")
    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

