package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.Documentos;
import com.arrendamiento.proyect.dto.DocumentosDTO;

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
public interface DocumentosMapper {
    @Mapping(source = "cliente.idCliente", target = "idCliente_Cliente")
    public DocumentosDTO documentosToDocumentosDTO(Documentos documentos)
        throws Exception;

    @Mapping(source = "idCliente_Cliente", target = "cliente.idCliente")
    public Documentos documentosDTOToDocumentos(DocumentosDTO documentosDTO)
        throws Exception;

    public List<DocumentosDTO> listDocumentosToListDocumentosDTO(
        List<Documentos> documentoss) throws Exception;

    public List<Documentos> listDocumentosDTOToListDocumentos(
        List<DocumentosDTO> documentosDTOs) throws Exception;
}
