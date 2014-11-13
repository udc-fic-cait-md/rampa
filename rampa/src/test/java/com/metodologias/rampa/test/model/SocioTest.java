package com.metodologias.rampa.test.model;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.metodologias.rampa.model.Socio;
import com.metodologias.rampa.service.SocioService;

/**
 * The Class SocioTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring/config/BeanLocations.xml")
public class SocioTest extends TestCase {

    /** The app context. */
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext(
            "file:src/main/resources/spring/config/BeanLocations.xml");

    /** The socio service. */
    private final SocioService socioService = (SocioService) this.appContext.getBean("socioService");

    /** The default timeout. */
    private static final int DEFAULT_TIMEOUT = 1000;

    /** The nombre. */
    private static final String NOMBRE = "Elías";

    /** The APELLIDO 1. */
    private static final String APELLIDO1 = "Fidalgo";

    /** The APELLIDO 2. */
    private static final String APELLIDO2 = "Fernández";

    /** The email. */
    private static final String EMAIL = "elias.fidalgo.fernandez@udc.es";

    /** The Constant DIRECCION. */
    private static final String DIRECCION = "Facultad de Informática. Campus de Elviña. A Coruña";

    /** The Constant TELEFONO. */
    private static final String TELEFONO = "981000000";

    /** The Constant NUMERO. */
    private static final Long NUMERO = new Long(123456);

    /** The socio. */
    private Socio socio;

    /**
     * Inicializar socio.
     */
    @Before
    public void inicializarSocio() {
        this.socio = new Socio();
        this.socio.setNombre(NOMBRE);
        this.socio.setApellido1(APELLIDO1);
        this.socio.setApellido2(APELLIDO2);
        this.socio.setEmail(EMAIL);
        this.socio.setDireccion(DIRECCION);
        this.socio.setTelefono(TELEFONO);
        this.socio.setNumero(NUMERO);
        this.socioService.save(this.socio);
    }

    /**
     * Eliminar socio.
     */
    @After
    public void eliminarSocio() {
        this.socioService.delete(this.socio);
        this.socio = null;
    }

    /**
     * Test numero.
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testNumero() {
        final Socio socioBD = this.socioService.findByNumero(NUMERO);
        assertEquals(NUMERO, socioBD.getNumero());
    }

    /**
     * Test nombre.
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testNombre() {
        final Socio socioBD = this.socioService.findByNumero(NUMERO);
        assertEquals(this.socio.getNumero(), socioBD.getNumero());
    }

    /**
     * Test apellido1.
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testApellido1() {
        final Socio socioBD = this.socioService.findByNumero(NUMERO);
        assertEquals(this.socio.getApellido1(), socioBD.getApellido1());
    }

    /**
     * Test apellido2.
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testApellido2() {
        final Socio socioBD = this.socioService.findByNumero(NUMERO);
        assertEquals(this.socio.getApellido2(), socioBD.getApellido2());
    }

    /**
     * Test email.
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testEmail() {
        final Socio socioBD = this.socioService.findByNumero(NUMERO);
        assertEquals(this.socio.getEmail(), socioBD.getEmail());
    }

}
