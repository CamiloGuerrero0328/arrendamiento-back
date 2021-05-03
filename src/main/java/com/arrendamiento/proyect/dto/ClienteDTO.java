package com.arrendamiento.proyect.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ClienteDTO.class);
    private String apellidoCliente;
    private String documento;
    private Integer idCliente;
    private String nombreCliente;
    private Long telefonoCliente;
    private Integer idTipoCliente_TipoCliente;
    private Integer idTipoDocumento_TipoDocumento;
    private Integer idUsuario_Usuario;

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(Long telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Integer getIdTipoCliente_TipoCliente() {
        return idTipoCliente_TipoCliente;
    }

    public void setIdTipoCliente_TipoCliente(Integer idTipoCliente_TipoCliente) {
        this.idTipoCliente_TipoCliente = idTipoCliente_TipoCliente;
    }

    public Integer getIdTipoDocumento_TipoDocumento() {
        return idTipoDocumento_TipoDocumento;
    }

    public void setIdTipoDocumento_TipoDocumento(
        Integer idTipoDocumento_TipoDocumento) {
        this.idTipoDocumento_TipoDocumento = idTipoDocumento_TipoDocumento;
    }

    public Integer getIdUsuario_Usuario() {
        return idUsuario_Usuario;
    }

    public void setIdUsuario_Usuario(Integer idUsuario_Usuario) {
        this.idUsuario_Usuario = idUsuario_Usuario;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());

            return super.toString();
        }
    }
}
