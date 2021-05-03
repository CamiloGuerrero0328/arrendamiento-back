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
public class TipoClienteServiceImpl implements TipoClienteService{

	private static final Logger log = LoggerFactory.getLogger(TipoClienteServiceImpl.class);

	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(TipoCliente tipoCliente)throws Exception{		
		 try {
			Set<ConstraintViolation<TipoCliente>> constraintViolations =validator.validate(tipoCliente);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<TipoCliente> constraintViolation : constraintViolations) {
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
	 	return tipoClienteRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoCliente> findAll(){
		log.debug("finding all TipoCliente instances");
       	return tipoClienteRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public TipoCliente save(TipoCliente entity) throws Exception {
		log.debug("saving TipoCliente instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("TipoCliente");
		}
		
		validate(entity);	
	
		if(tipoClienteRepository.findById(entity.getIdTipoCliente()).isPresent()){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return tipoClienteRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save TipoCliente failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(TipoCliente entity) throws Exception {
            	log.debug("deleting TipoCliente instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("TipoCliente");
	    		}
    	
                                if(entity.getIdTipoCliente()==null){
                    throw new ZMessManager().new EmptyFieldException("idTipoCliente");
                    }
                        
            	            findById(entity.getIdTipoCliente()).ifPresent(entidad->{	            	
	                													List<Cliente> clientes = entidad.getClientes();
							                    if(Utilities.validationsList(clientes)==true){
                       	 	throw new ZMessManager().new DeletingException("clientes");
                        }
	                	            });
                       

            try {
            
            tipoClienteRepository.deleteById(entity.getIdTipoCliente());
            log.debug("delete TipoCliente successful");
            
            } catch (Exception e) {
            	log.error("delete TipoCliente failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting TipoCliente instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("idTipoCliente");
            	}
            	if(tipoClienteRepository.findById(id).isPresent()){
           			delete(tipoClienteRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public TipoCliente update(TipoCliente entity) throws Exception {

				log.debug("updating TipoCliente instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("TipoCliente");
		    		}
		    		
	            validate(entity);
	
	            return tipoClienteRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update TipoCliente failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<TipoCliente> findById(Integer idTipoCliente) throws Exception {            
            	log.debug("getting TipoCliente instance");
            	return tipoClienteRepository.findById(idTipoCliente);
            }
			
}
