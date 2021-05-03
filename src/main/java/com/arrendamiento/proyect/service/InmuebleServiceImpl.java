package com.arrendamiento.proyect.service;

import com.arrendamiento.proyect.domain.*;
import com.arrendamiento.proyect.exception.*;
import com.arrendamiento.proyect.repository.*;
import com.arrendamiento.proyect.utility.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.ejb.access.EjbAccessException;
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
public class InmuebleServiceImpl implements InmuebleService {
    private static final Logger log = LoggerFactory.getLogger(InmuebleServiceImpl.class);
    @Autowired
    private InmuebleRepository inmuebleRepository;
    @Autowired
    private ClienteRepository clienteReposiroty;
    @Autowired
    private Validator validator;
    @Autowired 	
	SendEmailServiceImpl sendEmailServiceImpl;

    @Override
    public void validate(Inmueble inmueble) throws Exception {
        try {
            Set<ConstraintViolation<Inmueble>> constraintViolations = validator.validate(inmueble);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Inmueble> constraintViolation : constraintViolations) {
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
        return inmuebleRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inmueble> findAll() {
        log.debug("finding all Inmueble instances");

        return inmuebleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Inmueble save(Inmueble entity) throws Exception {
        log.debug("saving Inmueble instance");
        String correo;
        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Inmueble");
            }

            validate(entity);

            if (inmuebleRepository.findById(entity.getIdInmueble()).isPresent()) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }
            
//            inmuebleRepository.save(entity);
             Inmueble inmueble = inmuebleRepository.save(entity);
//            Inmueble inmueble = inmuebleRepository.findById(entity.getIdInmueble()).get();
            correo = inmueble.getCliente().getUsuario().getCorreoElectronico();
            System.out.println(inmueble.getIdInmueble()+"+++++++++++++++++++++++++++++++++++++");
            System.out.println(correo+"+++++++++++++++++++++++++++++++++++++");
            sendEmailServiceImpl.sendOpenAccount(correo, inmueble);
            
            return entity;
        } catch (Exception e) {
            log.error("save Inmueble failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Inmueble entity) throws Exception {
        log.debug("deleting Inmueble instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Inmueble");
        }

        if (entity.getIdInmueble() == null) {
            throw new ZMessManager().new EmptyFieldException("idInmueble");
        }

        try {
            inmuebleRepository.deleteById(entity.getIdInmueble());
            log.debug("delete Inmueble successful");
        } catch (Exception e) {
            log.error("delete Inmueble failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteById(Integer id) throws Exception {
        log.debug("deleting Inmueble instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("idInmueble");
        }

        if (inmuebleRepository.findById(id).isPresent()) {
            delete(inmuebleRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Inmueble update(Inmueble entity) throws Exception {
        log.debug("updating Inmueble instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Inmueble");
            }

            validate(entity);

            return inmuebleRepository.save(entity);
        } catch (Exception e) {
            log.error("update Inmueble failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Inmueble> findById(Integer idInmueble)
        throws Exception {
        log.debug("getting Inmueble instance");

        return inmuebleRepository.findById(idInmueble);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Inmueble> findByIdInmueble(int idInmueble)
        throws Exception {
        log.debug("getting Inmueble instance");

        return inmuebleRepository.findByIdInmueble(idInmueble);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Inmueble> findByIdCliente(Integer idCliente)
        throws Exception {
        log.debug("getting Inmueble instance");

        return inmuebleRepository.findByIdCliente(idCliente);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Inmueble> findInmueblesAplicados(Integer idCliente)
        throws Exception {
        log.debug("getting Inmueble instance");

        return inmuebleRepository.findInmueblesAplicados(idCliente);
    }
 
}
