package com.arrendamiento.proyect.controller;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.dto.ReporteDTO;
import com.arrendamiento.proyect.mapper.ReporteMapper;
import com.arrendamiento.proyect.service.ReporteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@RestController
@RequestMapping("/api/reporte")
@CrossOrigin(origins = "*")
public class ReporteRestController {
	private static final Logger log = LoggerFactory.getLogger(ReporteRestController.class);
    @Autowired
    private ReporteService reporteService;
    @Autowired
    private ReporteMapper reporteMapper;

    @GetMapping(value = "/findById/{idReporte}")
    public ResponseEntity<?> findById(@PathVariable("idReporte")
    Long idReporte) throws Exception {
        log.debug("Request to findById() Reporte");

        Reporte reporte = (reporteService.findById(idReporte).isPresent() == true)
            ? reporteService.findById(idReporte).get() : null;

        return ResponseEntity.ok()
                             .body(reporteMapper.reporteToReporteDTO(reporte));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Reporte");

        return ResponseEntity.ok()
                             .body(reporteMapper.listReporteToListReporteDTO(
                reporteService.findAll()));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@Valid
    @RequestBody
    ReporteDTO reporteDTO) throws Exception {
        log.debug("Request to save Reporte: {}", reporteDTO);

        Reporte reporte = reporteMapper.reporteDTOToReporte(reporteDTO);
        reporte = reporteService.save(reporte);

        return ResponseEntity.ok()
                             .body(reporteMapper.reporteToReporteDTO(reporte));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@Valid
    @RequestBody
    ReporteDTO reporteDTO) throws Exception {
        log.debug("Request to update Reporte: {}", reporteDTO);

        Reporte reporte = reporteMapper.reporteDTOToReporte(reporteDTO);
        reporte = reporteService.update(reporte);

        return ResponseEntity.ok()
                             .body(reporteMapper.reporteToReporteDTO(reporte));
    }

    @DeleteMapping(value = "/delete/{idReporte}")
    public ResponseEntity<?> delete(@PathVariable("idReporte")
    Long idReporte) throws Exception {
        log.debug("Request to delete Reporte");

        reporteService.deleteById(idReporte);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(reporteService.count());
    }
    
    @GetMapping(value = "/findByIdInmueble/{idInmueble}")
    public ResponseEntity<?> findByIdInmueble(@PathVariable("idInmueble")Integer idInmueble) {
        log.debug("Request to findByIdInmueble() Reporte");

        try {
            List<Reporte> reporte = reporteService.findByIdInmueble(idInmueble);

            return ResponseEntity.ok()
                                 .body(reporteMapper.listReporteToListReporteDTO(reporte));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
