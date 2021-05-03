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
@Table(name = "tipo_cliente", schema = "public")
public class TipoCliente implements java.io.Serializable {
    @NotNull
    private Integer idTipoCliente;
    private String nombreTipoCliente;
    private List<Cliente> clientes = new ArrayList<Cliente>(0);

    public TipoCliente() {
    }

    public TipoCliente(Integer idTipoCliente, List<Cliente> clientes,
        String nombreTipoCliente) {
        this.idTipoCliente = idTipoCliente;
        this.nombreTipoCliente = nombreTipoCliente;
        this.clientes = clientes;
    }

    @Id
    @Column(name = "id_tipo_cliente", unique = true, nullable = false)
    public Integer getIdTipoCliente() {
        return this.idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    @Column(name = "nombre_tipo_cliente")
    public String getNombreTipoCliente() {
        return this.nombreTipoCliente;
    }

    public void setNombreTipoCliente(String nombreTipoCliente) {
        this.nombreTipoCliente = nombreTipoCliente;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoCliente")
    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
