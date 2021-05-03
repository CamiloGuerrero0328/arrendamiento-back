package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.Abogado;
import com.arrendamiento.proyect.dto.AbogadoDTO;

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
public interface AbogadoMapper {
    @Mapping(source = "usuario.idUsuario", target = "idUsuario_Usuario")
    public AbogadoDTO abogadoToAbogadoDTO(Abogado abogado)
        throws Exception;

    @Mapping(source = "idUsuario_Usuario", target = "usuario.idUsuario")
    public Abogado abogadoDTOToAbogado(AbogadoDTO abogadoDTO)
        throws Exception;

    public List<AbogadoDTO> listAbogadoToListAbogadoDTO(List<Abogado> abogados)
        throws Exception;

    public List<Abogado> listAbogadoDTOToListAbogado(
        List<AbogadoDTO> abogadoDTOs) throws Exception;
}
