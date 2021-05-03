package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.Reporte;
import com.arrendamiento.proyect.dto.ReporteDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface ReporteMapper {
    @Mapping(source = "cliente.idCliente", target = "idCliente_Cliente")
    @Mapping(source = "inmueble.idInmueble", target = "idInmueble_Inmueble")
    public ReporteDTO reporteToReporteDTO(Reporte reporte);

    @Mapping(source = "idCliente_Cliente", target = "cliente.idCliente")
    @Mapping(source = "idInmueble_Inmueble", target = "inmueble.idInmueble")
    public Reporte reporteDTOToReporte(ReporteDTO reporteDTO);

    public List<ReporteDTO> listReporteToListReporteDTO(List<Reporte> reportes);

    public List<Reporte> listReporteDTOToListReporte(
        List<ReporteDTO> reporteDTOs);
}
