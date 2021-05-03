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
public class DocumentosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DocumentosDTO.class);
    private String cartaLaboral;
    private String cedulaCiudadania;
    private String codeudor;
    private Date fechaIngreso;
    private Integer idDocumentos;
    private String rut;
    private String solicitudArrendamiento;
    private Integer idCliente_Cliente;

    public String getCartaLaboral() {
        return cartaLaboral;
    }

    public void setCartaLaboral(String cartaLaboral) {
        this.cartaLaboral = cartaLaboral;
    }

    public String getCedulaCiudadania() {
        return cedulaCiudadania;
    }

    public void setCedulaCiudadania(String cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }

    public String getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(String codeudor) {
        this.codeudor = codeudor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdDocumentos() {
        return idDocumentos;
    }

    public void setIdDocumentos(Integer idDocumentos) {
        this.idDocumentos = idDocumentos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getSolicitudArrendamiento() {
        return solicitudArrendamiento;
    }

    public void setSolicitudArrendamiento(String solicitudArrendamiento) {
        this.solicitudArrendamiento = solicitudArrendamiento;
    }

    public Integer getIdCliente_Cliente() {
        return idCliente_Cliente;
    }

    public void setIdCliente_Cliente(Integer idCliente_Cliente) {
        this.idCliente_Cliente = idCliente_Cliente;
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
