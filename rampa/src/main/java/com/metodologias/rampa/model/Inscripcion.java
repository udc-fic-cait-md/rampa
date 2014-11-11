package com.metodologias.rampa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Class Inscripcion.
 */
@Entity
public class Inscripcion {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The fecha alta. */
    private Date fechaAlta;

    /** The fecha baja. */
    private Date fechaBaja;

    /** The pago al dia. */
    private boolean pagoAlDia;

    /** The alumno. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALUMNO_ID")
    private Alumno alumno;

    /** The actividad. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACTIVIDAD_ID")
    private Actividad actividad;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the fecha alta.
     *
     * @return the fecha alta
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Sets the fecha alta.
     *
     * @param fechaAlta
     *            the new fecha alta
     */
    public void setFechaAlta(final Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * Gets the fecha baja.
     *
     * @return the fecha baja
     */
    public Date getFechaBaja() {
        return fechaBaja;
    }

    /**
     * Sets the fecha baja.
     *
     * @param fechaBaja
     *            the new fecha baja
     */
    public void setFechaBaja(final Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    /**
     * Checks if is pago al dia.
     *
     * @return true, if is pago al dia
     */
    public boolean isPagoAlDia() {
        return pagoAlDia;
    }

    /**
     * Sets the pago al dia.
     *
     * @param pagoAlDia
     *            the new pago al dia
     */
    public void setPagoAlDia(final boolean pagoAlDia) {
        this.pagoAlDia = pagoAlDia;
    }

    /**
     * Gets the alumno.
     *
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Sets the alumno.
     *
     * @param alumno
     *            the new alumno
     */
    public void setAlumno(final Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Gets the actividad.
     *
     * @return the actividad
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * Sets the actividad.
     *
     * @param actividad
     *            the new actividad
     */
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}
