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
public class ProcesoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProcesoDTO.class);
    private Boolean estado;
    private Date fechaProceso;
    private Integer idProceso;
    private String nombreProceso;
    private Integer idAbogado_Abogado;
    private Integer idCliente_Cliente;
    private Integer idInmueble_Inmueble;
    private String info;
    private Boolean pagado;

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public Integer getIdAbogado_Abogado() {
        return idAbogado_Abogado;
    }

    public void setIdAbogado_Abogado(Integer idAbogado_Abogado) {
        this.idAbogado_Abogado = idAbogado_Abogado;
    }

    public Integer getIdCliente_Cliente() {
        return idCliente_Cliente;
    }

    public void setIdCliente_Cliente(Integer idCliente_Cliente) {
        this.idCliente_Cliente = idCliente_Cliente;
    }
    
    ////
    public Integer getIdInmueble_Inmueble() {
        return idInmueble_Inmueble;
    }

    public void setIdInmueble_Inmueble(Integer idInmueble_Inmueble) {
        this.idInmueble_Inmueble = idInmueble_Inmueble;
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
