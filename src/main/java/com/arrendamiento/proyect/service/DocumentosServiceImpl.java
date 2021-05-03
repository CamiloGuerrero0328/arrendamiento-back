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

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
public class DocumentosServiceImpl implements DocumentosService {
    private static final Logger log = LoggerFactory.getLogger(DocumentosServiceImpl.class);
    @Autowired
    private DocumentosRepository documentosRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(Documentos documentos) throws Exception {
        try {
            Set<ConstraintViolation<Documentos>> constraintViolations = validator.validate(documentos);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Documentos> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return documentosRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Documentos> findAll() {
        log.debug("finding all Documentos instances");

        return documentosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Documentos save(Documentos entity) throws Exception {
        log.debug("saving Documentos instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Documentos");
            }

            validate(entity);

            if (documentosRepository.findById(entity.getIdDocumentos())
                                        .isPresent()) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            return documentosRepository.save(entity);
        } catch (Exception e) {
            log.error("save Documentos failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Documentos entity) throws Exception {
        log.debug("deleting Documentos instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Documentos");
        }

        if (entity.getIdDocumentos() == null) {
            throw new ZMessManager().new EmptyFieldException("idDocumentos");
        }

        try {
            documentosRepository.deleteById(entity.getIdDocumentos());
            log.debug("delete Documentos successful");
        } catch (Exception e) {
            log.error("delete Documentos failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteById(Integer id) throws Exception {
        log.debug("deleting Documentos instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("idDocumentos");
        }

        if (documentosRepository.findById(id).isPresent()) {
            delete(documentosRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Documentos update(Documentos entity) throws Exception {
        log.debug("updating Documentos instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Documentos");
            }

            validate(entity);

            return documentosRepository.save(entity);
        } catch (Exception e) {
            log.error("update Documentos failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Documentos> findById(Integer idDocumentos)
        throws Exception {
        log.debug("getting Documentos instance");

        return documentosRepository.findById(idDocumentos);
    }
    
    @Override
	@Transactional(readOnly=true)
    public List<Documentos> findByIdCliente(int id) throws Exception {            
    	log.debug("getting Cliente instance");
    	return documentosRepository.findByIdCliente(id);
    }
}
