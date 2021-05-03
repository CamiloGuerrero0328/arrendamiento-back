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
public class AbogadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AbogadoDTO.class);
    private String apellidoAbogado;
    private String correoElectronico;
    private String estado;
    private Integer idAbogado;
    private String nombreAbogado;
    private Long telefonoAbogado;
    private Integer idUsuario_Usuario;

    public String getApellidoAbogado() {
        return apellidoAbogado;
    }

    public void setApellidoAbogado(String apellidoAbogado) {
        this.apellidoAbogado = apellidoAbogado;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(Integer idAbogado) {
        this.idAbogado = idAbogado;
    }

    public String getNombreAbogado() {
        return nombreAbogado;
    }

    public void setNombreAbogado(String nombreAbogado) {
        this.nombreAbogado = nombreAbogado;
    }

    public Long getTelefonoAbogado() {
        return telefonoAbogado;
    }

    public void setTelefonoAbogado(Long telefonoAbogado) {
        this.telefonoAbogado = telefonoAbogado;
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
