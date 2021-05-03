package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.Proceso;
import com.arrendamiento.proyect.dto.ProcesoDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface ProcesoMapper {
    @Mapping(source = "abogado.idAbogado", target = "idAbogado_Abogado")
    @Mapping(source = "cliente.idCliente", target = "idCliente_Cliente")
    @Mapping(source = "inmueble.idInmueble", target = "idInmueble_Inmueble")
    public ProcesoDTO procesoToProcesoDTO(Proceso proceso)
        throws Exception;

    @Mapping(source = "idAbogado_Abogado", target = "abogado.idAbogado")
    @Mapping(source = "idCliente_Cliente", target = "cliente.idCliente")
    @Mapping(source = "idInmueble_Inmueble", target = "inmueble.idInmueble")
    public Proceso procesoDTOToProceso(ProcesoDTO procesoDTO)
        throws Exception;

    public List<ProcesoDTO> listProcesoToListProcesoDTO(List<Proceso> procesos)
        throws Exception;

    public List<Proceso> listProcesoDTOToListProceso(
        List<ProcesoDTO> procesoDTOs) throws Exception;
}
