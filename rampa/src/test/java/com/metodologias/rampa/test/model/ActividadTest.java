package com.metodologias.rampa.test.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.service.ActividadService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class ActividadTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(CommonNaming.ARCHIVO_BEANS)
public class ActividadTest extends TestCase {

    /** The app context. */
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext(CommonNaming.ARCHIVO_BEANS);

    /** The socio service. */
    private final ActividadService actividadService = (ActividadService) this.appContext
            .getBean(CommonNaming.BEAN_SERVICIO_ACTIVIDAD);

    /** The Constant NOMBRE. */
    private static final String NOMBRE = "Visita a Museo";

    /** The Constant CODIGO. */
    private static final String CODIGO = "0001";

    /** The Constant CUOTA. */
    private static final Double CUOTA = 10.95;

    /** The Constant DESCRIPCION. */
    private static final String DESCRIPCION = "Visita al Museo Centro Gaias en Santiago de Compostela";

    /** The Constant FECHA_INICIO. */
    private static final Date FECHA_INICIO = new GregorianCalendar(2014, Calendar.NOVEMBER, 1).getTime();

    /** The Constant FECHA_FIN. */
    private static final Date FECHA_FIN = new GregorianCalendar(2014, Calendar.JANUARY, 1).getTime();

    /** The actividad. */
    private Actividad actividad;

    /**
     * Inicializar actividad.
     */
    @Before
    public void inicializarActividad() {
        this.actividad = new Actividad();
        this.actividad.setNombre(NOMBRE);
        this.actividad.setCodigo(CODIGO);
        this.actividad.setCuota(CUOTA);
        this.actividad.setDescripcion(DESCRIPCION);
        this.actividad.setFechaInicio(FECHA_INICIO);
        this.actividad.setFechaFin(FECHA_FIN);
        this.actividadService.save(this.actividad);
    }

    /**
     * Eliminar actividad.
     */
    @After
    public void eliminarActividad() {
        this.actividadService.delete(this.actividad);
        this.actividad = null;
    }

    /**
     * Test numero.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testCodigo() {
        final Actividad actividadBD = this.actividadService.findByCodigoActividad(CODIGO);
        assertEquals(this.actividad.getCodigo(), actividadBD.getCodigo());
    }

    /**
     * Test nombre.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testNombre() {
        final Actividad actividadBD = this.actividadService.findByCodigoActividad(CODIGO);
        assertEquals(this.actividad.getNombre(), actividadBD.getNombre());
    }

    /**
     * Test cuota.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testCuota() {
        final Actividad actividadBD = this.actividadService.findByCodigoActividad(CODIGO);
        assertEquals(this.actividad.getCuota(), actividadBD.getCuota());
    }

    /**
     * Test descripcion.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testDescripcion() {
        final Actividad actividadBD = this.actividadService.findByCodigoActividad(CODIGO);
        assertEquals(this.actividad.getDescripcion(), actividadBD.getDescripcion());
    }

    /**
     * Test fecha inicio.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testFechaInicio() {
        final Actividad actividadBD = this.actividadService.findByCodigoActividad(CODIGO);
        assertEquals(this.actividad.getFechaInicio(), actividadBD.getFechaInicio());
    }

    /**
     * Test fecha fin.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testFechaFin() {
        final Actividad actividadBD = this.actividadService.findByCodigoActividad(CODIGO);
        assertEquals(this.actividad.getFechaFin(), actividadBD.getFechaFin());
    }

}
