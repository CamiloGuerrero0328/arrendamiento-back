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
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

	private static final Logger log = LoggerFactory.getLogger(TipoDocumentoServiceImpl.class);

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(TipoDocumento tipoDocumento)throws Exception{		
		 try {
			Set<ConstraintViolation<TipoDocumento>> constraintViolations =validator.validate(tipoDocumento);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<TipoDocumento> constraintViolation : constraintViolations) {
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
	 	return tipoDocumentoRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoDocumento> findAll(){
		log.debug("finding all TipoDocumento instances");
       	return tipoDocumentoRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public TipoDocumento save(TipoDocumento entity) throws Exception {
		log.debug("saving TipoDocumento instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("TipoDocumento");
		}
		
		validate(entity);	
	
		if(tipoDocumentoRepository.findById(entity.getIdTipoDocumento()).isPresent()){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return tipoDocumentoRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save TipoDocumento failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(TipoDocumento entity) throws Exception {
            	log.debug("deleting TipoDocumento instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("TipoDocumento");
	    		}
    	
                                if(entity.getIdTipoDocumento()==null){
                    throw new ZMessManager().new EmptyFieldException("idTipoDocumento");
                    }
                        
            	            findById(entity.getIdTipoDocumento()).ifPresent(entidad->{	            	
	                													List<Cliente> clientes = entidad.getClientes();
							                    if(Utilities.validationsList(clientes)==true){
                       	 	throw new ZMessManager().new DeletingException("clientes");
                        }
	                	            });
                       

            try {
            
            tipoDocumentoRepository.deleteById(entity.getIdTipoDocumento());
            log.debug("delete TipoDocumento successful");
            
            } catch (Exception e) {
            	log.error("delete TipoDocumento failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting TipoDocumento instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("idTipoDocumento");
            	}
            	if(tipoDocumentoRepository.findById(id).isPresent()){
           			delete(tipoDocumentoRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public TipoDocumento update(TipoDocumento entity) throws Exception {

				log.debug("updating TipoDocumento instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("TipoDocumento");
		    		}
		    		
	            validate(entity);
	
	            return tipoDocumentoRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update TipoDocumento failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<TipoDocumento> findById(Integer idTipoDocumento) throws Exception {            
            	log.debug("getting TipoDocumento instance");
            	return tipoDocumentoRepository.findById(idTipoDocumento);
            }
			
}
