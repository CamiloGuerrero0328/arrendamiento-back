package com.arrendamiento.proyect.controller;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.dto.ClienteDTO;
import com.arrendamiento.proyect.mapper.ClienteMapper;
import com.arrendamiento.proyect.service.ClienteService;

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
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteRestController {
	private static final Logger log = LoggerFactory.getLogger(ClienteRestController.class);
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteMapper clienteMapper;

	@GetMapping(value = "/findById/{idCliente}")
	public ResponseEntity<?> findById(@PathVariable("idCliente") Integer idCliente) {
		log.debug("Request to findById() Cliente");

		try {
			Cliente cliente = clienteService.findById(idCliente).get();

			return ResponseEntity.ok().body(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/findByTipoCliente/{id}")
	public ResponseEntity<?> findByTipoCliente(@PathVariable("id") int id) {
		log.debug("Request to findByTipoCliente() Cliente");

		try {
			List<Cliente> clientes = clienteService.findByTipoCliente(id);

			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(clientes));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/findClientByIdUser/{id}")
	public ResponseEntity<?> findClientByIdUser(@PathVariable("id") int id) {
		log.debug("Request to findClientByIdUser() Cliente");

		try {
			Cliente cliente = clienteService.findClientByIdUser(id);

			return ResponseEntity.ok().body(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<?> findAll() {
		log.debug("Request to findAll() Cliente");

		try {
			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(clienteService.findAll()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO) {
		log.debug("Request to save Cliente: {}", clienteDTO);

		try {
			Cliente cliente = clienteMapper.clienteDTOToCliente(clienteDTO);
			cliente = clienteService.save(cliente);

			return ResponseEntity.ok().body(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<?> update(@RequestBody ClienteDTO clienteDTO) {
		log.debug("Request to update Cliente: {}", clienteDTO);

		try {
			Cliente cliente = clienteMapper.clienteDTOToCliente(clienteDTO);
			cliente = clienteService.update(cliente);

			return ResponseEntity.ok().body(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/delete/{idCliente}")
	public ResponseEntity<?> delete(@PathVariable("idCliente") Integer idCliente) throws Exception {
		log.debug("Request to delete Cliente");

		try {
			Cliente cliente = clienteService.findById(idCliente).get();

			clienteService.delete(cliente);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(clienteService.count());
	}
}
