package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.Inmueble;
import com.arrendamiento.proyect.dto.InmuebleDTO;

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
public interface InmuebleMapper {
    @Mapping(source = "cliente.idCliente", target = "idCliente")
    public InmuebleDTO inmuebleToInmuebleDTO(Inmueble inmueble)
        throws Exception;

    @Mapping(source = "idCliente", target = "cliente.idCliente")
    public Inmueble inmuebleDTOToInmueble(InmuebleDTO inmuebleDTO)
        throws Exception;

    public List<InmuebleDTO> listInmuebleToListInmuebleDTO(
        List<Inmueble> inmuebles) throws Exception;

    public List<Inmueble> listInmuebleDTOToListInmueble(
        List<InmuebleDTO> inmuebleDTOs) throws Exception;
}
