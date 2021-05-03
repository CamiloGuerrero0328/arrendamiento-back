package com.arrendamiento.proyect.controller;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.dto.AbogadoDTO;
import com.arrendamiento.proyect.mapper.AbogadoMapper;
import com.arrendamiento.proyect.service.AbogadoService;

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
@RequestMapping("/api/abogado")
@CrossOrigin(origins = "*")
public class AbogadoRestController {
    private static final Logger log = LoggerFactory.getLogger(AbogadoRestController.class);
    @Autowired
    private AbogadoService abogadoService;
    @Autowired
    private AbogadoMapper abogadoMapper;

    @GetMapping(value = "/findById/{idAbogado}")
    public ResponseEntity<?> findById(
        @PathVariable("idAbogado")
    Integer idAbogado) {
        log.debug("Request to findById() Abogado");

        try {
            Abogado abogado = abogadoService.findById(idAbogado).get();

            return ResponseEntity.ok()
                                 .body(abogadoMapper.abogadoToAbogadoDTO(
                    abogado));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping(value = "/findAbogadoByIdUser/{id}")
	public ResponseEntity<?> findAbogadoByIdUser(@PathVariable("id") int id) {
		log.debug("Request to findAbogadoByIdUser() Abogado");
		try {
			Abogado abogado = abogadoService.findAbogadoByIdUser(id);
			return ResponseEntity.ok().body(abogadoMapper.abogadoToAbogadoDTO(abogado));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() Abogado");

        try {
            return ResponseEntity.ok()
                                 .body(abogadoMapper.listAbogadoToListAbogadoDTO(
                    abogadoService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    AbogadoDTO abogadoDTO) {
        log.debug("Request to save Abogado: {}", abogadoDTO);

        try {
            Abogado abogado = abogadoMapper.abogadoDTOToAbogado(abogadoDTO);
            abogado = abogadoService.save(abogado);

            return ResponseEntity.ok()
                                 .body(abogadoMapper.abogadoToAbogadoDTO(
                    abogado));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    AbogadoDTO abogadoDTO) {
        log.debug("Request to update Abogado: {}", abogadoDTO);

        try {
            Abogado abogado = abogadoMapper.abogadoDTOToAbogado(abogadoDTO);
            abogado = abogadoService.update(abogado);

            return ResponseEntity.ok()
                                 .body(abogadoMapper.abogadoToAbogadoDTO(
                    abogado));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idAbogado}")
    public ResponseEntity<?> delete(@PathVariable("idAbogado")
    Integer idAbogado) throws Exception {
        log.debug("Request to delete Abogado");

        try {
            Abogado abogado = abogadoService.findById(idAbogado).get();

            abogadoService.delete(abogado);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(abogadoService.count());
    }
}
