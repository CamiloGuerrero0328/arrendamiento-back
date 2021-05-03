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
@Table(name = "tipo_usuario", schema = "public")
public class TipoUsuario implements java.io.Serializable {
    @NotNull
    private Integer idTipoUsuario;
    @NotNull
    private String estado;
    @NotNull
    private String nombreUsuario;
    @NotNull
    private List<Usuario> usuarios = new ArrayList<Usuario>(0);

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idTipoUsuario, String estado,
        String nombreUsuario, List<Usuario> usuarios) {
        this.idTipoUsuario = idTipoUsuario;
        this.estado = estado;
        this.nombreUsuario = nombreUsuario;
        this.usuarios = usuarios;
    }

    @Id
    @Column(name = "id_tipo_usuario", unique = true, nullable = false)
    public Integer getIdTipoUsuario() {
        return this.idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Column(name = "estado")
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_usuario")
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoUsuario")
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
