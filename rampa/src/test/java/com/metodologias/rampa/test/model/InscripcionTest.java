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

import com.metodologias.rampa.model.Inscripcion;
import com.metodologias.rampa.service.InscripcionService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class InscripcionTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(CommonNaming.ARCHIVO_BEANS)
public class InscripcionTest extends TestCase {

    /** The app context. */
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext(CommonNaming.ARCHIVO_BEANS);

    /** The inscripcion service. */
    private final InscripcionService inscripcionService = (InscripcionService) this.appContext
            .getBean(CommonNaming.BEAN_SERVICIO_INSCRIPCION);

    /** The Constant FECHA_ALTA. */
    private static final Date FECHA_ALTA = new GregorianCalendar(2012, Calendar.JANUARY, 1).getTime();

    /** The Constant FECHA_BAJA. */
    private static final Date FECHA_BAJA = new GregorianCalendar(2014, Calendar.JANUARY, 1).getTime();

    /** The Constant PAGO_AL_DIA. */
    private static final Boolean PAGO_AL_DIA = Boolean.TRUE;

    /** The inscripcion. */
    private Inscripcion inscripcion;

    /**
     * Inicializar inscripcion.
     */
    @Before
    public void inicializarInscripcion() {
        this.inscripcion = new Inscripcion();
        this.inscripcion.setFechaAlta(FECHA_ALTA);
        this.inscripcion.setFechaBaja(FECHA_BAJA);
        this.inscripcion.setPagoAlDia(PAGO_AL_DIA);
        this.inscripcionService.save(this.inscripcion);
    }

    /**
     * Eliminar inscripcion.
     */
    @After
    public void eliminarInscripcion() {
        this.inscripcionService.delete(this.inscripcion);
        this.inscripcion = null;
    }

    /**
     * Test fecha alta.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testFechaAlta() {
        final Inscripcion inscripcionBD = this.inscripcionService.findById(this.inscripcion.getId());
        assertEquals(this.inscripcion.getFechaAlta(), inscripcionBD.getFechaAlta());
    }

    /**
     * Test fecha baja.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testFechaBaja() {
        final Inscripcion inscripcionBD = this.inscripcionService.findById(this.inscripcion.getId());
        assertEquals(this.inscripcion.getFechaBaja(), inscripcionBD.getFechaBaja());
    }

    /**
     * Test pago al dia.
     */
    @Test(timeout = CommonNaming.DEFAULT_TIMEOUT)
    public void testPagoAlDia() {
        final Inscripcion inscripcionBD = this.inscripcionService.findById(this.inscripcion.getId());
        assertEquals(this.inscripcion.isPagoAlDia(), inscripcionBD.isPagoAlDia());
    }

}
