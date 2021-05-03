package com.arrendamiento.proyect.controller;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.dto.InmuebleDTO;
import com.arrendamiento.proyect.mapper.InmuebleMapper;
import com.arrendamiento.proyect.service.InmuebleService;

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
@RequestMapping("/api/inmueble")
@CrossOrigin(origins = "*")
public class InmuebleRestController {
	private static final Logger log = LoggerFactory.getLogger(InmuebleRestController.class);
	@Autowired
	private InmuebleService inmuebleService;
	@Autowired
	private InmuebleMapper inmuebleMapper;

	@GetMapping(value = "/findById/{idInmueble}")
	public ResponseEntity<?> findById(@PathVariable("idInmueble") Integer idInmueble) {
		log.debug("Request to findById() Inmueble");

		try {
			Inmueble inmueble = inmuebleService.findById(idInmueble).get();

			return ResponseEntity.ok().body(inmuebleMapper.inmuebleToInmuebleDTO(inmueble));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(value = "/findByIdInmueble/{idInmueble}")
	public ResponseEntity<?> findByIdInmueble(@PathVariable("idInmueble") int idInmueble) {
		log.debug("Request to findByIdInmueble() Inmueble");

		try {
			List<Inmueble> inmueble = inmuebleService.findByIdInmueble(idInmueble);

			return ResponseEntity.ok().body(inmuebleMapper.listInmuebleToListInmuebleDTO(inmueble));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/findByIdCliente/{idCliente}")
	public ResponseEntity<?> findByIdCliente(@PathVariable("idCliente") Integer idCliente) {
		log.debug("Request to findById() Inmueble");

		try {
			List<Inmueble> inmuebles = inmuebleService.findByIdCliente(idCliente);

			return ResponseEntity.ok().body(inmuebleMapper.listInmuebleToListInmuebleDTO(inmuebles));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(value = "/findInmueblesAplicados/{idCliente}")
	public ResponseEntity<?> findInmueblesAplicados(@PathVariable("idCliente") Integer idCliente) {
		log.debug("Request to findInmueblesAplicados() Inmueble");

		try {
			List<Inmueble> inmuebles = inmuebleService.findInmueblesAplicados(idCliente);

			return ResponseEntity.ok().body(inmuebleMapper.listInmuebleToListInmuebleDTO(inmuebles));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<?> findAll() {
		log.debug("Request to findAll() Inmueble");

		try {
			return ResponseEntity.ok().body(inmuebleMapper.listInmuebleToListInmuebleDTO(inmuebleService.findAll()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@RequestBody InmuebleDTO inmuebleDTO) {
		log.debug("Request to save Inmueble: {}", inmuebleDTO);

		try {
			Inmueble inmueble = inmuebleMapper.inmuebleDTOToInmueble(inmuebleDTO);
			inmueble = inmuebleService.save(inmueble);

			return ResponseEntity.ok().body(inmuebleMapper.inmuebleToInmuebleDTO(inmueble));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<?> update(@RequestBody InmuebleDTO inmuebleDTO) {
		log.debug("Request to update Inmueble: {}", inmuebleDTO);

		try {
			Inmueble inmueble = inmuebleMapper.inmuebleDTOToInmueble(inmuebleDTO);
			inmueble = inmuebleService.update(inmueble);

			return ResponseEntity.ok().body(inmuebleMapper.inmuebleToInmuebleDTO(inmueble));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/delete/{idInmueble}")
	public ResponseEntity<?> delete(@PathVariable("idInmueble") Integer idInmueble) throws Exception {
		log.debug("Request to delete Inmueble");

		try {
			Inmueble inmueble = inmuebleService.findById(idInmueble).get();

			inmuebleService.delete(inmueble);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(inmuebleService.count());
	}
}
