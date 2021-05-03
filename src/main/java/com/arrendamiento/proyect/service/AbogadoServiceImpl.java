package  com.arrendamiento.proyect.service;


import java.math.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.arrendamiento.proyect.exception.*;
import com.arrendamiento.proyect.repository.*;
import com.arrendamiento.proyect.utility.Utilities;

import com.arrendamiento.proyect.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class AbogadoServiceImpl implements AbogadoService{

	private static final Logger log = LoggerFactory.getLogger(AbogadoServiceImpl.class);

	@Autowired
	private AbogadoRepository abogadoRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Abogado abogado)throws Exception{		
		 try {
			Set<ConstraintViolation<Abogado>> constraintViolations =validator.validate(abogado);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<Abogado> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath().toString());
					strMessage.append(" - ");
					strMessage.append(constraintViolation.getMessage());
					strMessage.append(". \n");
				}
				 throw new Exception(strMessage.toString());
			 }
		 }catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return abogadoRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Abogado> findAll(){
		log.debug("finding all Abogado instances");
       	return abogadoRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public Abogado save(Abogado entity) throws Exception {
		log.debug("saving Abogado instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Abogado");
		}
		
		validate(entity);	
	
		if(abogadoRepository.findById(entity.getIdAbogado()).isPresent()){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return abogadoRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save Abogado failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(Abogado entity) throws Exception {
            	log.debug("deleting Abogado instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Abogado");
	    		}
    	
                                if(entity.getIdAbogado()==null){
                    throw new ZMessManager().new EmptyFieldException("idAbogado");
                    }
                        
            	            findById(entity.getIdAbogado()).ifPresent(entidad->{	            	
	                													List<Proceso> procesos = entidad.getProcesos();
							                    if(Utilities.validationsList(procesos)==true){
                       	 	throw new ZMessManager().new DeletingException("procesos");
                        }
	                	            });
                       

            try {
            
            abogadoRepository.deleteById(entity.getIdAbogado());
            log.debug("delete Abogado successful");
            
            } catch (Exception e) {
            	log.error("delete Abogado failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Abogado instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("idAbogado");
            	}
            	if(abogadoRepository.findById(id).isPresent()){
           			delete(abogadoRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public Abogado update(Abogado entity) throws Exception {

				log.debug("updating Abogado instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Abogado");
		    		}
		    		
	            validate(entity);
	
	            return abogadoRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update Abogado failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Abogado> findById(Integer idAbogado) throws Exception {            
            	log.debug("getting Abogado instance");
            	return abogadoRepository.findById(idAbogado);
            }
			
			@Override
			@Transactional(readOnly=true)
			public Abogado findAbogadoByIdUser(int idAbogado) throws Exception {            
            	log.debug("getting Abogado instance");
            	return abogadoRepository.findAbogadoByIdUser(idAbogado);
				
			}
}
