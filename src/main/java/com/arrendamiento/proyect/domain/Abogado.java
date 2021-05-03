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
@Table(name = "abogado", schema = "public")
public class Abogado implements java.io.Serializable {
    @NotNull
    private Integer idAbogado;
    @NotNull
    private Usuario usuario;
    private String apellidoAbogado;
    private String correoElectronico;
    private String estado;
    private String nombreAbogado;
    private Long telefonoAbogado;
    private List<Proceso> procesos = new ArrayList<Proceso>(0);

    public Abogado() {
    }

    public Abogado(Integer idAbogado, String apellidoAbogado,
        String correoElectronico, String estado, String nombreAbogado,
        List<Proceso> procesos, Long telefonoAbogado, Usuario usuario) {
        this.idAbogado = idAbogado;
        this.usuario = usuario;
        this.apellidoAbogado = apellidoAbogado;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
        this.nombreAbogado = nombreAbogado;
        this.telefonoAbogado = telefonoAbogado;
        this.procesos = procesos;
    }

    @Id
    @Column(name = "id_abogado", unique = true, nullable = false)
    public Integer getIdAbogado() {
        return this.idAbogado;
    }

    public void setIdAbogado(Integer idAbogado) {
        this.idAbogado = idAbogado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "apellido_abogado")
    public String getApellidoAbogado() {
        return this.apellidoAbogado;
    }

    public void setApellidoAbogado(String apellidoAbogado) {
        this.apellidoAbogado = apellidoAbogado;
    }

    @Column(name = "correo_electronico")
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Column(name = "estado")
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_abogado")
    public String getNombreAbogado() {
        return this.nombreAbogado;
    }

    public void setNombreAbogado(String nombreAbogado) {
        this.nombreAbogado = nombreAbogado;
    }

    @Column(name = "telefono_abogado")
    public Long getTelefonoAbogado() {
        return this.telefonoAbogado;
    }

    public void setTelefonoAbogado(Long telefonoAbogado) {
        this.telefonoAbogado = telefonoAbogado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "abogado")
    public List<Proceso> getProcesos() {
        return this.procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }
}
