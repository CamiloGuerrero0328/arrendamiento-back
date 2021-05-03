package com.arrendamiento.proyect.controller;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.dto.DocumentosDTO;
import com.arrendamiento.proyect.mapper.DocumentosMapper;
import com.arrendamiento.proyect.service.DocumentosService;

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
@RequestMapping("/api/documentos")
@CrossOrigin(origins = "*")
public class DocumentosRestController {
    private static final Logger log = LoggerFactory.getLogger(DocumentosRestController.class);
    @Autowired
    private DocumentosService documentosService;
    @Autowired
    private DocumentosMapper documentosMapper;

    @GetMapping(value = "/findById/{idDocumentos}")
    public ResponseEntity<?> findById(
        @PathVariable("idDocumentos")
    Integer idDocumentos) {
        log.debug("Request to findById() Documentos");

        try {
            Documentos documentos = documentosService.findById(idDocumentos)
                                                     .get();

            return ResponseEntity.ok()
                                 .body(documentosMapper.documentosToDocumentosDTO(
                    documentos));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping(value = "/findByIdCliente/{id}")
    public ResponseEntity<?> findByIdCliente(
        @PathVariable("id")
    int id) {
        log.debug("Request to findByIdCliente() Documentos");

        try {
            List<Documentos> documentos = documentosService.findByIdCliente(id);

            return ResponseEntity.ok().body(documentosMapper.listDocumentosToListDocumentosDTO(
                    documentos));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() Documentos");

        try {
            return ResponseEntity.ok()
                                 .body(documentosMapper.listDocumentosToListDocumentosDTO(
                    documentosService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    DocumentosDTO documentosDTO) {
        log.debug("Request to save Documentos: {}", documentosDTO);

        try {
            Documentos documentos = documentosMapper.documentosDTOToDocumentos(documentosDTO);
            documentos = documentosService.save(documentos);

            return ResponseEntity.ok()
                                 .body(documentosMapper.documentosToDocumentosDTO(
                    documentos));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    DocumentosDTO documentosDTO) {
        log.debug("Request to update Documentos: {}", documentosDTO);

        try {
            Documentos documentos = documentosMapper.documentosDTOToDocumentos(documentosDTO);
            documentos = documentosService.update(documentos);

            return ResponseEntity.ok()
                                 .body(documentosMapper.documentosToDocumentosDTO(
                    documentos));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idDocumentos}")
    public ResponseEntity<?> delete(
        @PathVariable("idDocumentos")
    Integer idDocumentos) throws Exception {
        log.debug("Request to delete Documentos");

        try {
            Documentos documentos = documentosService.findById(idDocumentos)
                                                     .get();

            documentosService.delete(documentos);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(documentosService.count());
    }
}
