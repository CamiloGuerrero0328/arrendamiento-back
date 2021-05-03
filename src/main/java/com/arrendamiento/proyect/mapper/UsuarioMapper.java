package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.Usuario;
import com.arrendamiento.proyect.dto.UsuarioDTO;

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
public interface UsuarioMapper {
    @Mapping(source = "tipoUsuario.idTipoUsuario", target = "idTipoUsuario")
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)
        throws Exception;

    @Mapping(source = "idTipoUsuario", target = "tipoUsuario.idTipoUsuario")
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)
        throws Exception;

    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> usuarios)
        throws Exception;

    public List<Usuario> listUsuarioDTOToListUsuario(
        List<UsuarioDTO> usuarioDTOs) throws Exception;
}
