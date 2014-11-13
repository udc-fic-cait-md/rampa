package com.metodologias.rampa.service;

import com.metodologias.rampa.model.Actividad;

/**
 * The Interface SocioService.
 */
public interface ActividadService {

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
    Actividad findByCodigoActividad(final String codigoActividad);

}
