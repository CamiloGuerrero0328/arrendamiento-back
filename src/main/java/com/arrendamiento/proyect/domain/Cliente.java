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
@Table(name = "cliente", schema = "public")
public class Cliente implements java.io.Serializable {
    @NotNull
    private Integer idCliente;
    @NotNull
    private TipoCliente tipoCliente;
    @NotNull
    private TipoDocumento tipoDocumento;
    @NotNull
    private Usuario usuario;
    private String apellidoCliente;
    private String documento;
    private String nombreCliente;
    private Long telefonoCliente;
    private List<Documentos> documentoses = new ArrayList<Documentos>(0);
    private List<Inmueble> inmuebles = new ArrayList<Inmueble>(0);
    private List<Proceso> procesos = new ArrayList<Proceso>(0);


    public Cliente() {
    }

    public Cliente(Integer idCliente, String apellidoCliente, String documento,
        List<Documentos> documentoses, List<Inmueble> inmuebles,
        String nombreCliente, List<Proceso> procesos, Long telefonoCliente,
        TipoCliente tipoCliente, TipoDocumento tipoDocumento, Usuario usuario) {
        this.idCliente = idCliente;
        this.tipoCliente = tipoCliente;
        this.tipoDocumento = tipoDocumento;
        this.usuario = usuario;
        this.apellidoCliente = apellidoCliente;
        this.documento = documento;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.documentoses = documentoses;
        this.inmuebles = inmuebles;
        this.procesos = procesos;
    }

    @Id
    @Column(name = "id_cliente", unique = true, nullable = false)
    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_cliente")
    public TipoCliente getTipoCliente() {
        return this.tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "apellido_cliente")
    public String getApellidoCliente() {
        return this.apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    @Column(name = "documento")
    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Column(name = "nombre_cliente")
    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Column(name = "telefono_cliente")
    public Long getTelefonoCliente() {
        return this.telefonoCliente;
    }

    public void setTelefonoCliente(Long telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public List<Documentos> getDocumentoses() {
        return this.documentoses;
    }

    public void setDocumentoses(List<Documentos> documentoses) {
        this.documentoses = documentoses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public List<Inmueble> getInmuebles() {
        return this.inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public List<Proceso> getProcesos() {
        return this.procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }
    
}
