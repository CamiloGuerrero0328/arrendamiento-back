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
public class ProcesoServiceImpl implements ProcesoService {
    private static final Logger log = LoggerFactory.getLogger(ProcesoServiceImpl.class);
    @Autowired
    private ProcesoRepository procesoRepository;
    @Autowired
    private Validator validator;
    @Autowired 	
	SendEmailServiceImpl sendEmailServiceImpl;

    @Override
    public void validate(Proceso proceso) throws Exception {
        try {
            Set<ConstraintViolation<Proceso>> constraintViolations = validator.validate(proceso);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Proceso> constraintViolation : constraintViolations) {
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
        return procesoRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proceso> findAll() {
        log.debug("finding all Proceso instances");

        return procesoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Proceso save(Proceso entity) throws Exception {
        log.debug("saving Proceso instance");
        String correoArrendador;
        String correoArrendatario;
        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Proceso");
            }

            validate(entity);

            if (procesoRepository.findById(entity.getIdProceso()).isPresent()) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }
            
            Date date = new Date();
            entity.setFechaProceso(date);
            System.out.println(entity.getFechaProceso());

            Proceso proceso = procesoRepository.save(entity); 
            
            correoArrendador = proceso.getInmueble().getCliente().getUsuario().getCorreoElectronico();
            correoArrendatario = proceso.getCliente().getUsuario().getCorreoElectronico();
            
            sendEmailServiceImpl.notificationAvisoInmuebleArrendatario(correoArrendatario, proceso);
            sendEmailServiceImpl.notificationAvisoInmuebleArrendador(correoArrendador, proceso);
            
            return entity;
        } catch (Exception e) {
            log.error("save Proceso failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Proceso entity) throws Exception {
        log.debug("deleting Proceso instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Proceso");
        }

        if (entity.getIdProceso() == null) {
            throw new ZMessManager().new EmptyFieldException("idProceso");
        }

        try {
            procesoRepository.deleteById(entity.getIdProceso());
            log.debug("delete Proceso successful");
        } catch (Exception e) {
            log.error("delete Proceso failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteById(Integer id) throws Exception {
        log.debug("deleting Proceso instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("idProceso");
        }

        if (procesoRepository.findById(id).isPresent()) {
            delete(procesoRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Proceso update(Proceso entity) throws Exception {
        log.debug("updating Proceso instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Proceso");
            }

            validate(entity);

            return procesoRepository.save(entity);
        } catch (Exception e) {
            log.error("update Proceso failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Proceso> findById(Integer idProceso)
        throws Exception {
        log.debug("getting Proceso instance");

        return procesoRepository.findById(idProceso);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Proceso> findByIdCliente(Integer idProceso)
        throws Exception {
        log.debug("getting Proceso instance");

        return procesoRepository.findByIdCliente(idProceso);
    }
     
}
