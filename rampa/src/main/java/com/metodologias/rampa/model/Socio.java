package com.metodologias.rampa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Socio.
 */
@Entity
public class Socio {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The numero. */
    private Long numero;

    /** The nombre. */
    private String nombre;

    /** The apellido1. */
    private String apellido1;

    /** The apellido2. */
    private String apellido2;

    /** The direccion. */
    private String direccion;

    /** The telefono. */
    private String telefono;

    /** The email. */
    private String email;

    /** The alumnos. */
    @OneToMany(mappedBy = "socio")
    private List<Alumno> alumnos;

    /**
     * Gets the alumnos.
     *
     * @return the alumnos
     */
    public List<Alumno> getAlumnos() {
        return this.alumnos;
    }

    /**
     * Sets the alumnos.
     *
     * @param alumnos
     *            the new alumnos
     */
    public void setAlumnos(final List<Alumno> alumnos) {
        this.alumnos = alumnos;
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
     * Gets the numero.
     *
     * @return the numero
     */
    public Long getNumero() {
        return this.numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero
     *            the new numero
     */
    public void setNumero(final Long numero) {
        this.numero = numero;
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
     * Gets the direccion.
     *
     * @return the direccion
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Sets the direccion.
     *
     * @param direccion
     *            the new direccion
     */
    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets the telefono.
     *
     * @return the telefono
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Sets the telefono.
     *
     * @param telefono
     *            the new telefono
     */
    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the new email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

}