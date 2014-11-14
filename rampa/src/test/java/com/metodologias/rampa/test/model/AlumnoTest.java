package com.metodologias.rampa.test.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.service.AlumnoService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class AlumnoTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(CommonNaming.ARCHIVO_BEANS)
public class AlumnoTest {

    /** The app context. */
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext(CommonNaming.ARCHIVO_BEANS);

    /** The alumno service. */
    private final AlumnoService alumnoService = (AlumnoService) this.appContext
            .getBean(CommonNaming.BEAN_SERVICIO_ALUMNO);

    /** The nombre. */
    private static final String NOMBRE = "Elias";

    /** The APELLIDO 1. */
    private static final String APELLIDO1 = "Fidalgo";

    /** The APELLIDO 2. */
    private static final String APELLIDO2 = "Fernandez";

    /** The Constant CURSO. */
    private static final String CURSO = "3ºA";

    /** The Constant FECHA_NACIMIENTO. */
    private static final Date FECHA_NACIMIENTO = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();

    /** The alumno. */
    private Alumno alumno;

    /**
     * Inicializar alumno.
     */
    @Before
    public void inicializarAlumno() {
        this.alumno = new Alumno();
        this.alumno.setNombre(NOMBRE);
        this.alumno.setApellido1(APELLIDO1);
        this.alumno.setApellido2(APELLIDO2);
        this.alumno.setCurso(CURSO);
        this.alumno.setFechaNacimiento(FECHA_NACIMIENTO);
        this.alumnoService.save(this.alumno);
    }

    /**
     * Eliminar alumno.
     */
    @After
    public void eliminarAlumno() {
        this.alumnoService.delete(this.alumno);
        this.alumno = null;
    }

    /**
     * Test nombre.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testNombre() {
        final Alumno alumnoBD = this.alumnoService.findById(this.alumno.getId());
        assertEquals(this.alumno.getNombre(), alumnoBD.getNombre());
    }

    /**
     * Test apellido1.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testApellido1() {
        final Alumno alumnoBD = this.alumnoService.findById(this.alumno.getId());
        assertEquals(this.alumno.getApellido1(), alumnoBD.getApellido1());
    }

    /**
     * Test apellido2.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testApellido2() {
        final Alumno alumnoBD = this.alumnoService.findById(this.alumno.getId());
        assertEquals(this.alumno.getApellido2(), alumnoBD.getApellido2());
    }

    /**
     * Test curso.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testCurso() {
        final Alumno alumnoBD = this.alumnoService.findById(this.alumno.getId());
        assertEquals(this.alumno.getCurso(), alumnoBD.getCurso());
    }

    /**
     * Test fecha nacimiento.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testFechaNacimiento() {
        final Alumno alumnoBD = this.alumnoService.findById(this.alumno.getId());
        assertEquals(this.alumno.getFechaNacimiento(), alumnoBD.getFechaNacimiento());
    }
}
