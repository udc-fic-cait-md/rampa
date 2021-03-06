package com.metodologias.rampa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class Alumno.
 */
@Entity
public class Alumno implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9187835744874271989L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The nombre. */
    private String nombre;

    /** The apellido1. */
    private String apellido1;

    /** The apellido2. */
    private String apellido2;

    /** The fecha nacimiento. */
    private Date fechaNacimiento;

    /** The curso. */
    private String curso;

    /** The observaciones. */
    private String observaciones;

    /** The socio. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SOCIO_ID")
    private Socio socio;

    /** The inscripciones. */
    @OneToMany(mappedBy = CommonNaming.ALUMNO)
    private List<Inscripcion> inscripciones;

    /**
     * Gets the inscripciones.
     *
     * @return the inscripciones
     */
    public List<Inscripcion> getInscripciones() {
        return this.inscripciones;
    }

    /**
     * Sets the inscripciones.
     *
     * @param inscripciones
     *            the new inscripciones
     */
    public void setInscripciones(final List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    /**
     * Gets the socio.
     *
     * @return the socio
     */
    public Socio getSocio() {
        return this.socio;
    }

    /**
     * Sets the socio.
     *
     * @param socio
     *            the new socio
     */
    public void setSocio(final Socio socio) {
        this.socio = socio;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
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
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param nombre
     *            the new nombre
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the apellido1.
     *
     * @return the apellido1
     */
    public String getApellido1() {
        return this.apellido1;
    }

    /**
     * Sets the apellido1.
     *
     * @param apellido1
     *            the new apellido1
     */
    public void setApellido1(final String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Gets the apellido2.
     *
     * @return the apellido2
     */
    public String getApellido2() {
        return this.apellido2;
    }

    /**
     * Sets the apellido2.
     *
     * @param apellido2
     *            the new apellido2
     */
    public void setApellido2(final String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Gets the fecha nacimiento.
     *
     * @return the fecha nacimiento
     */
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    /**
     * Sets the fecha nacimiento.
     *
     * @param fechaNacimiento
     *            the new fecha nacimiento
     */
    public void setFechaNacimiento(final Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Gets the curso.
     *
     * @return the curso
     */
    public String getCurso() {
        return this.curso;
    }

    /**
     * Sets the curso.
     *
     * @param curso
     *            the new curso
     */
    public void setCurso(final String curso) {
        this.curso = curso;
    }

    /**
     * Gets the observaciones.
     *
     * @return the observaciones
     */
    public String getObservaciones() {
        return this.observaciones;
    }

    /**
     * Sets the observaciones.
     *
     * @param observaciones
     *            the new observaciones
     */
    public void setObservaciones(final String observaciones) {
        this.observaciones = observaciones;
    }

}
