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
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @NotNull
    private TipoUsuario tipoUsuario;
    @NotNull
    private String contrasena;
    @NotNull
    private String correoElectronico;
    private List<Abogado> abogados = new ArrayList<Abogado>(0);
    private List<Cliente> clientes = new ArrayList<Cliente>(0);

    public Usuario() {
    }

    public Usuario(Integer idUsuario, List<Abogado> abogados,
        List<Cliente> clientes, String contrasena, String correoElectronico,
        TipoUsuario tipoUsuario) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.abogados = abogados;
        this.clientes = clientes;
    }

    @Id
    @Column(name = "id_usuario", unique = true, nullable = false)
    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_usuario")
    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Column(name = "contrasena")
    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Column(name = "correo_electronico")
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public List<Abogado> getAbogados() {
        return this.abogados;
    }

    public void setAbogados(List<Abogado> abogados) {
        this.abogados = abogados;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
