package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.TipoCliente;
import com.arrendamiento.proyect.dto.TipoClienteDTO;

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
public interface TipoClienteMapper {
    public TipoClienteDTO tipoClienteToTipoClienteDTO(TipoCliente tipoCliente)
        throws Exception;

    public TipoCliente tipoClienteDTOToTipoCliente(
        TipoClienteDTO tipoClienteDTO) throws Exception;

    public List<TipoClienteDTO> listTipoClienteToListTipoClienteDTO(
        List<TipoCliente> tipoClientes) throws Exception;

    public List<TipoCliente> listTipoClienteDTOToListTipoCliente(
        List<TipoClienteDTO> tipoClienteDTOs) throws Exception;
}
