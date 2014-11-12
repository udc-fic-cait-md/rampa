package com.metodologias.rampa.test.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.repository.impl.AlumnoRepositoryImpl;

/**
 * The Class AlumnoTest.
 */
public class AlumnoTest {

    private final ApplicationContext appContext = new ClassPathXmlApplicationContext(
            "file:src/main/resources/spring/config/BeanLocations.xml");

    private final AlumnoRepositoryImpl alumnoRepository = (AlumnoRepositoryImpl) this.appContext
            .getBean("alumnoRepository");

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
        this.alumnoRepository.save(this.alumno);
    }

    /**
     * Eliminar alumno.
     */
    @After
    public void eliminarAlumno() {
        this.alumnoRepository.delete(this.alumno);
        this.alumno = null;
    }
}
