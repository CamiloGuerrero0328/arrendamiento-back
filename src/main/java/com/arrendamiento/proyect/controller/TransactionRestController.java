package com.arrendamiento.proyect.controller;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.dto.TransactionDTO;
import com.arrendamiento.proyect.mapper.TransactionMapper;
import com.arrendamiento.proyect.service.TransactionService;

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

import javax.validation.Valid;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@RestController
@RequestMapping("/api/transaction")
@CrossOrigin(origins = "*")
public class TransactionRestController {
	private static final Logger log = LoggerFactory.getLogger(TransactionRestController.class);
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionMapper transactionMapper;

    @GetMapping(value = "/findById/{idTransaction}")
    public ResponseEntity<?> findById(
        @PathVariable("idTransaction")
    Long idTransaction) throws Exception {
        log.debug("Request to findById() Transaction");

        Transaction transaction = (transactionService.findById(idTransaction)
                                                     .isPresent() == true)
            ? transactionService.findById(idTransaction).get() : null;

        return ResponseEntity.ok()
                             .body(transactionMapper.transactionToTransactionDTO(
                transaction));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Transaction");

        return ResponseEntity.ok()
                             .body(transactionMapper.listTransactionToListTransactionDTO(
                transactionService.findAll()));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    TransactionDTO transactionDTO) throws Exception {
        log.debug("Request to save Transaction: {}", transactionDTO);

        Transaction transaction = transactionMapper.transactionDTOToTransaction(transactionDTO);
        transaction = transactionService.save(transaction);

        return ResponseEntity.ok()
                             .body(transactionMapper.transactionToTransactionDTO(
                transaction));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    TransactionDTO transactionDTO) throws Exception {
        log.debug("Request to update Transaction: {}", transactionDTO);

        Transaction transaction = transactionMapper.transactionDTOToTransaction(transactionDTO);
        transaction = transactionService.update(transaction);

        return ResponseEntity.ok()
                             .body(transactionMapper.transactionToTransactionDTO(
                transaction));
    }

    @DeleteMapping(value = "/delete/{idTransaction}")
    public ResponseEntity<?> delete(
        @PathVariable("idTransaction")
    Long idTransaction) throws Exception {
        log.debug("Request to delete Transaction");

        transactionService.deleteById(idTransaction);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(transactionService.count());
    }
}
