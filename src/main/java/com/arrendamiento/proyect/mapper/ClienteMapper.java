package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.Cliente;
import com.arrendamiento.proyect.dto.ClienteDTO;

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
public interface ClienteMapper {
    @Mapping(source = "tipoCliente.idTipoCliente", target = "idTipoCliente_TipoCliente")
    @Mapping(source = "tipoDocumento.idTipoDocumento", target = "idTipoDocumento_TipoDocumento")
    @Mapping(source = "usuario.idUsuario", target = "idUsuario_Usuario")
    public ClienteDTO clienteToClienteDTO(Cliente cliente)
        throws Exception;

    @Mapping(source = "idTipoCliente_TipoCliente", target = "tipoCliente.idTipoCliente")
    @Mapping(source = "idTipoDocumento_TipoDocumento", target = "tipoDocumento.idTipoDocumento")
    @Mapping(source = "idUsuario_Usuario", target = "usuario.idUsuario")
    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO)
        throws Exception;

    public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> clientes)
        throws Exception;

    public List<Cliente> listClienteDTOToListCliente(
        List<ClienteDTO> clienteDTOs) throws Exception;
}
