package com.arrendamiento.proyect.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tipo_documento", schema = "public")
public class TipoDocumento implements java.io.Serializable {
    @NotNull
    private Integer idTipoDocumento;
    private String estado;
    private String nombreDocumento;
    private List<Cliente> clientes = new ArrayList<Cliente>(0);

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idTipoDocumento, List<Cliente> clientes,
        String estado, String nombreDocumento) {
        this.idTipoDocumento = idTipoDocumento;
        this.estado = estado;
        this.nombreDocumento = nombreDocumento;
        this.clientes = clientes;
    }

    @Id
    @Column(name = "id_tipo_documento", unique = true, nullable = false)
    public Integer getIdTipoDocumento() {
        return this.idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Column(name = "estado")
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_documento")
    public String getNombreDocumento() {
        return this.nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDocumento")
    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
