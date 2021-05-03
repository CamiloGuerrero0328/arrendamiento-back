package com.arrendamiento.proyect.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@SpringBootTest
public class AbogadoServiceTest {
    private static final Logger log = LoggerFactory.getLogger(AbogadoServiceTest.class);
    @Autowired
    private AbogadoService abogadoService;

    @Test
    @DisplayName("findAll")
    public void findAll() {
        assertNotNull(abogadoService);
    }

    @Test
    @DisplayName("save")
    public void save() throws Exception {
        assertNotNull(abogadoService);
    }

    @Test
    @DisplayName("delete")
    public void delete() throws Exception {
        assertNotNull(abogadoService);
    }

    @Test
    @DisplayName("deleteById")
    public void deleteById() throws Exception {
        assertNotNull(abogadoService);
    }

    @Test
    @DisplayName("update")
    public void update() throws Exception {
        assertNotNull(abogadoService);
    }

    @Test
    @DisplayName("findById")
    public void findById() throws Exception {
        assertNotNull(abogadoService);
    }

    @Test
    @DisplayName("count")
    public void count() throws Exception {
        assertNotNull(abogadoService);
    }
}
