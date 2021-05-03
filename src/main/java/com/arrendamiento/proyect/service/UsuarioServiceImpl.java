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
public class UsuarioServiceImpl implements UsuarioService{

	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Usuario usuario)throws Exception{		
		 try {
			Set<ConstraintViolation<Usuario>> constraintViolations =validator.validate(usuario);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<Usuario> constraintViolation : constraintViolations) {
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
	 	return usuarioRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll(){
		log.debug("finding all Usuario instances");
       	return usuarioRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public Usuario save(Usuario entity) throws Exception {
		log.debug("saving Usuario instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Usuario");
		}
		
		validate(entity);	
	
		if(usuarioRepository.findById(entity.getIdUsuario()).isPresent()){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return usuarioRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save Usuario failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(Usuario entity) throws Exception {
            	log.debug("deleting Usuario instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Usuario");
	    		}
    	
                                if(entity.getIdUsuario()==null){
                    throw new ZMessManager().new EmptyFieldException("idUsuario");
                    }
                        
            	            findById(entity.getIdUsuario()).ifPresent(entidad->{	            	
	                													List<Abogado> abogados = entidad.getAbogados();
							                    if(Utilities.validationsList(abogados)==true){
                       	 	throw new ZMessManager().new DeletingException("abogados");
                        }
	                													List<Cliente> clientes = entidad.getClientes();
							                    if(Utilities.validationsList(clientes)==true){
                       	 	throw new ZMessManager().new DeletingException("clientes");
                        }
	                	            });
                       

            try {
            
            usuarioRepository.deleteById(entity.getIdUsuario());
            log.debug("delete Usuario successful");
            
            } catch (Exception e) {
            	log.error("delete Usuario failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Usuario instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("idUsuario");
            	}
            	if(usuarioRepository.findById(id).isPresent()){
           			delete(usuarioRepository.findById(id).get());
       			}    
            }	
            
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public Usuario update(Usuario entity) throws Exception {

				log.debug("updating Usuario instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Usuario");
		    		}
		    		
	            validate(entity);
	
	            return usuarioRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update Usuario failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Usuario> findById(Integer idUsuario) throws Exception {            
            	log.debug("getting Usuario instance");
            	return usuarioRepository.findById(idUsuario);
            }
			
			
			@Transactional(readOnly=true)
            public Usuario findByEmail(String correoElectronico) throws Exception {  
            	log.debug("getting Usuario instance");
            	return usuarioRepository.findByEmail(correoElectronico);
			}
			
			
			
}
