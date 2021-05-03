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
public class TipoUsuarioServiceImpl implements TipoUsuarioService{

	private static final Logger log = LoggerFactory.getLogger(TipoUsuarioServiceImpl.class);

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(TipoUsuario tipoUsuario)throws Exception{		
		 try {
			Set<ConstraintViolation<TipoUsuario>> constraintViolations =validator.validate(tipoUsuario);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<TipoUsuario> constraintViolation : constraintViolations) {
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
	 	return tipoUsuarioRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoUsuario> findAll(){
		log.debug("finding all TipoUsuario instances");
       	return tipoUsuarioRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public TipoUsuario save(TipoUsuario entity) throws Exception {
		log.debug("saving TipoUsuario instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("TipoUsuario");
		}
		
		validate(entity);	
	
		if(tipoUsuarioRepository.findById(entity.getIdTipoUsuario()).isPresent()){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return tipoUsuarioRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save TipoUsuario failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(TipoUsuario entity) throws Exception {
            	log.debug("deleting TipoUsuario instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("TipoUsuario");
	    		}
    	
                                if(entity.getIdTipoUsuario()==null){
                    throw new ZMessManager().new EmptyFieldException("idTipoUsuario");
                    }
                        
            	            findById(entity.getIdTipoUsuario()).ifPresent(entidad->{	            	
	                													List<Usuario> usuarios = entidad.getUsuarios();
							                    if(Utilities.validationsList(usuarios)==true){
                       	 	throw new ZMessManager().new DeletingException("usuarios");
                        }
	                	            });
                       

            try {
            
            tipoUsuarioRepository.deleteById(entity.getIdTipoUsuario());
            log.debug("delete TipoUsuario successful");
            
            } catch (Exception e) {
            	log.error("delete TipoUsuario failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting TipoUsuario instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("idTipoUsuario");
            	}
            	if(tipoUsuarioRepository.findById(id).isPresent()){
           			delete(tipoUsuarioRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public TipoUsuario update(TipoUsuario entity) throws Exception {

				log.debug("updating TipoUsuario instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("TipoUsuario");
		    		}
		    		
	            validate(entity);
	
	            return tipoUsuarioRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update TipoUsuario failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<TipoUsuario> findById(Integer idTipoUsuario) throws Exception {            
            	log.debug("getting TipoUsuario instance");
            	return tipoUsuarioRepository.findById(idTipoUsuario);
            }
			
}
