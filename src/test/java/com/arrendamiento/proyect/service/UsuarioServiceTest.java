package com.arrendamiento.proyect.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.arrendamiento.proyect.domain.TipoUsuario;
import com.arrendamiento.proyect.domain.Usuario;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@SpringBootTest
public class UsuarioServiceTest {
    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceTest.class);
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @Test
    @DisplayName("findAll")
    public void findAll() {
        assertNotNull(usuarioService);
    }

    @Test
    @DisplayName("save")
    public void save() throws Exception {
        assertNotNull(usuarioService);
//        Usuario user = new Usuario();
//		user.setIdUsuario(100);
//		user.setCorreoElectronico("juann@hotmail.com");
//		user.setContrasena("contrase");
//		
//		Optional<TipoUsuario> userTypeOptional = tipoUsuarioService.findById(2);
//		assertTrue(userTypeOptional.isPresent(), "El tipo de usuario no existe");
//		
//		TipoUsuario userType = userTypeOptional.get();		
//		user.setTipoUsuario(userType);
//		
//		try {
//			usuarioService.save(user);
//		} catch (Exception e) {
//			assertNull(e,e.getMessage());
//		}		
    }

    @Test
    @DisplayName("delete")
    public void delete() throws Exception {
        assertNotNull(usuarioService);
    }

    @Test
    @DisplayName("deleteById")
    public void deleteById() throws Exception {
        assertNotNull(usuarioService);
    }

    @Test
    @DisplayName("update")
    public void update() throws Exception {
        assertNotNull(usuarioService);
    }

    @Test
    @DisplayName("findById")
    public void findById() throws Exception {
        assertNotNull(usuarioService);
    }

    @Test
    @DisplayName("count")
    public void count() throws Exception {
        assertNotNull(usuarioService);
    }
}
