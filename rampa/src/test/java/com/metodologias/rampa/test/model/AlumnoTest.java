package com.metodologias.rampa.test.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.service.AlumnoService;

/**
 * The Class AlumnoTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring/config/BeanLocations.xml")
public class AlumnoTest {

    /** The app context. */
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext(
            "file:src/main/resources/spring/config/BeanLocations.xml");

    /** The alumno service. */
    private final AlumnoService alumnoService = (AlumnoService) this.appContext.getBean("alumnoService");

    /** The default timeout. */
    private static final int DEFAULT_TIMEOUT = 1000;

    /** The nombre. */
    private static final String NOMBRE = "Elias";

    /** The APELLIDO 1. */
    private static final String APELLIDO1 = "Fidalgo";

    /** The APELLIDO 2. */
    private static final String APELLIDO2 = "Fernandez";

    /** The Constant CURSO. */
    private static final String CURSO = "3ºA";

    /** The Constant FECHA_NACIMIENTO. */
    private static final Date FECHA_NACIMIENTO = new GregorianCalendar(1987, Calendar.AUGUST, 9).getTime();

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

}
