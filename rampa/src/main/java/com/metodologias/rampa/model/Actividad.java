package com.metodologias.rampa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Actividad.
 */
@Entity
public class Actividad {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The nombre. */
    private String nombre;

    /** The codigo. */
    private String codigo;

    /** The cuota. */
    private Double cuota;

    /** The descripcion. */
    private String descripcion;

    /** The fecha inicio. */
    private Date fechaInicio;

    /** The fecha fin. */
    private Date fechaFin;

    /** The inscripciones. */
    @OneToMany(mappedBy = "actividad")
    private List<Inscripcion> inscripciones;

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
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
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
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo
     *            the new codigo
     */
    public void setCodigo(final String codigo) {
        this.codigo = codigo;
    }

    /**
     * Gets the cuota.
     *
     * @return the cuota
     */
    public Double getCuota() {
        return cuota;
    }

    /**
     * Sets the cuota.
     *
     * @param cuota
     *            the new cuota
     */
    public void setCuota(final Double cuota) {
        this.cuota = cuota;
    }

    /**
     * Gets the descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion.
     *
     * @param descripcion
     *            the new descripcion
     */
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets the fecha inicio.
     *
     * @return the fecha inicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Sets the fecha inicio.
     *
     * @param fechaInicio
     *            the new fecha inicio
     */
    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Gets the fecha fin.
     *
     * @return the fecha fin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Sets the fecha fin.
     *
     * @param fechaFin
     *            the new fecha fin
     */
    public void setFechaFin(final Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Gets the inscripciones.
     *
     * @return the inscripciones
     */
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
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

}
