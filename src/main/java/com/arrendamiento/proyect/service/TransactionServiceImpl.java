package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.exception.*;
import com.arrendamiento.proyect.repository.*;
import com.arrendamiento.proyect.utility.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
public class TransactionServiceImpl implements TransactionService {
	
	private static final Logger log = LoggerFactory.getLogger(ReporteServiceImpl.class);
	
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(Transaction transaction)
        throws ConstraintViolationException {
        Set<ConstraintViolation<Transaction>> constraintViolations = validator.validate(transaction);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return transactionRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> findAll() {
        log.debug("finding all Transaction instances");

        return transactionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Transaction save(Transaction entity) throws Exception {
        log.debug("saving Transaction instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Transaction");
        }

        validate(entity);

        if (transactionRepository.existsById(entity.getIdTransaction())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return transactionRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Transaction entity) throws Exception {
        log.debug("deleting Transaction instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Transaction");
        }

        if (entity.getIdTransaction() == null) {
            throw new ZMessManager().new EmptyFieldException("idTransaction");
        }

        if (transactionRepository.existsById(entity.getIdTransaction()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        transactionRepository.deleteById(entity.getIdTransaction());
        log.debug("delete Transaction successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) throws Exception {
        log.debug("deleting Transaction instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("idTransaction");
        }

        if (transactionRepository.existsById(id)) {
            delete(transactionRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Transaction update(Transaction entity) throws Exception {
        log.debug("updating Transaction instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Transaction");
        }

        validate(entity);

        if (transactionRepository.existsById(entity.getIdTransaction()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return transactionRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Transaction> findById(Long idTransaction) {
        log.debug("getting Transaction instance");

        return transactionRepository.findById(idTransaction);
    }
}
