package com.arrendamiento.proyect.controller;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.dto.TipoClienteDTO;
import com.arrendamiento.proyect.mapper.TipoClienteMapper;
import com.arrendamiento.proyect.service.TipoClienteService;

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
@RequestMapping("/api/tipoCliente")
@CrossOrigin(origins = "*")
public class TipoClienteRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoClienteRestController.class);
    @Autowired
    private TipoClienteService tipoClienteService;
    @Autowired
    private TipoClienteMapper tipoClienteMapper;

    @GetMapping(value = "/findById/{idTipoCliente}")
    public ResponseEntity<?> findById(
        @PathVariable("idTipoCliente")
    Integer idTipoCliente) {
        log.debug("Request to findById() TipoCliente");

        try {
            TipoCliente tipoCliente = tipoClienteService.findById(idTipoCliente)
                                                        .get();

            return ResponseEntity.ok()
                                 .body(tipoClienteMapper.tipoClienteToTipoClienteDTO(
                    tipoCliente));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() TipoCliente");

        try {
            return ResponseEntity.ok()
                                 .body(tipoClienteMapper.listTipoClienteToListTipoClienteDTO(
                    tipoClienteService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    TipoClienteDTO tipoClienteDTO) {
        log.debug("Request to save TipoCliente: {}", tipoClienteDTO);

        try {
            TipoCliente tipoCliente = tipoClienteMapper.tipoClienteDTOToTipoCliente(tipoClienteDTO);
            tipoCliente = tipoClienteService.save(tipoCliente);

            return ResponseEntity.ok()
                                 .body(tipoClienteMapper.tipoClienteToTipoClienteDTO(
                    tipoCliente));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    TipoClienteDTO tipoClienteDTO) {
        log.debug("Request to update TipoCliente: {}", tipoClienteDTO);

        try {
            TipoCliente tipoCliente = tipoClienteMapper.tipoClienteDTOToTipoCliente(tipoClienteDTO);
            tipoCliente = tipoClienteService.update(tipoCliente);

            return ResponseEntity.ok()
                                 .body(tipoClienteMapper.tipoClienteToTipoClienteDTO(
                    tipoCliente));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idTipoCliente}")
    public ResponseEntity<?> delete(
        @PathVariable("idTipoCliente")
    Integer idTipoCliente) throws Exception {
        log.debug("Request to delete TipoCliente");

        try {
            TipoCliente tipoCliente = tipoClienteService.findById(idTipoCliente)
                                                        .get();

            tipoClienteService.delete(tipoCliente);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(tipoClienteService.count());
    }
}
