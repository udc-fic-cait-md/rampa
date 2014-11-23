package com.metodologias.rampa.repository;

import java.util.List;

import com.metodologias.rampa.model.Actividad;

/**
 * The Interface ActividadRepository.
 */
public interface ActividadRepository {

    /**
     * Save.
     *
     * @param actividad
     *            the actividad
     */
    void save(Actividad actividad);

    /**
     * Update.
     *
     * @param actividad
     *            the actividad
     */
    void update(Actividad actividad);

    /**
     * Delete.
     *
     * @param actividad
     *            the actividad
     */
    void delete(Actividad actividad);

    /**
     * Find by codigo actividad.
     *
     * @param codigoActividad
     *            the codigo actividad
     * @return the actividad
     */
    Actividad findByCodigoActividad(String codigoActividad);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Actividad> findAll();

}