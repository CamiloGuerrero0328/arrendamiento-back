package com.arrendamiento.proyect.controller;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.dto.ProcesoDTO;
import com.arrendamiento.proyect.mapper.ProcesoMapper;
import com.arrendamiento.proyect.service.ProcesoService;

import java.util.List;

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


@RestController
@RequestMapping("/api/proceso")
@CrossOrigin(origins = "*")
public class ProcesoRestController {
    private static final Logger log = LoggerFactory.getLogger(ProcesoRestController.class);
    @Autowired
    private ProcesoService procesoService;
    @Autowired
    private ProcesoMapper procesoMapper;

    @GetMapping(value = "/findById/{idProceso}")
    public ResponseEntity<?> findById(
        @PathVariable("idProceso")
    Integer idProceso) {
        log.debug("Request to findById() Proceso");

        try {
            Proceso proceso = procesoService.findById(idProceso).get();

            return ResponseEntity.ok()
                                 .body(procesoMapper.procesoToProcesoDTO(
                    proceso));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping(value = "/findByIdCliente/{idCliente}")
    public ResponseEntity<?> findByIdCliente(
        @PathVariable("idCliente")
    Integer idProceso) {
        log.debug("Request to findByIdCliente() Proceso");

        try {
            List<Proceso> proceso = procesoService.findByIdCliente(idProceso);

            return ResponseEntity.ok()
                                 .body(procesoMapper.listProcesoToListProcesoDTO(
                    proceso));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() Proceso");

        try {
            return ResponseEntity.ok()
                                 .body(procesoMapper.listProcesoToListProcesoDTO(
                    procesoService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    ProcesoDTO procesoDTO) {
        log.debug("Request to save Proceso: {}", procesoDTO);

        try {
            Proceso proceso = procesoMapper.procesoDTOToProceso(procesoDTO);
            proceso = procesoService.save(proceso);

            return ResponseEntity.ok()
                                 .body(procesoMapper.procesoToProcesoDTO(
                    proceso));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    ProcesoDTO procesoDTO) {
        log.debug("Request to update Proceso: {}", procesoDTO);

        try {
            Proceso proceso = procesoMapper.procesoDTOToProceso(procesoDTO);
            proceso = procesoService.update(proceso);

            return ResponseEntity.ok()
                                 .body(procesoMapper.procesoToProcesoDTO(
                    proceso));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idProceso}")
    public ResponseEntity<?> delete(@PathVariable("idProceso")
    Integer idProceso) throws Exception {
        log.debug("Request to delete Proceso");

        try {
            Proceso proceso = procesoService.findById(idProceso).get();

            procesoService.delete(proceso);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(procesoService.count());
    }
}
