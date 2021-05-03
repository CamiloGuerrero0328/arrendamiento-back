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
public class ReporteServiceImpl implements ReporteService {
	
	private static final Logger log = LoggerFactory.getLogger(ReporteServiceImpl.class);
	
    @Autowired
    private ReporteRepository reporteRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(Reporte reporte) throws ConstraintViolationException {
        Set<ConstraintViolation<Reporte>> constraintViolations = validator.validate(reporte);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return reporteRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reporte> findAll() {
        log.debug("finding all Reporte instances");

        return reporteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Reporte save(Reporte entity) throws Exception {
        log.debug("saving Reporte instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Reporte");
        }

        validate(entity);

        if (reporteRepository.existsById(entity.getIdReporte())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return reporteRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Reporte entity) throws Exception {
        log.debug("deleting Reporte instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Reporte");
        }

        if (entity.getIdReporte() == null) {
            throw new ZMessManager().new EmptyFieldException("idReporte");
        }

        if (reporteRepository.existsById(entity.getIdReporte()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        reporteRepository.deleteById(entity.getIdReporte());
        log.debug("delete Reporte successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) throws Exception {
        log.debug("deleting Reporte instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("idReporte");
        }

        if (reporteRepository.existsById(id)) {
            delete(reporteRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Reporte update(Reporte entity) throws Exception {
        log.debug("updating Reporte instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Reporte");
        }

        validate(entity);

        if (reporteRepository.existsById(entity.getIdReporte()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return reporteRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reporte> findById(Long idReporte) {
        log.debug("getting Reporte instance");

        return reporteRepository.findById(idReporte);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reporte> findByIdInmueble(Integer idInmueble)
        throws Exception {
        log.debug("getting Proceso instance");

        return reporteRepository.findByIdInmueble(idInmueble);
    }
}
