package com.metodologias.rampa.service;

import com.metodologias.rampa.model.Inscripcion;

/**
 * The Interface SocioService.
 */
public interface InscripcionService {

    /**
     * Save.
     *
     * @param inscripcion
     *            the inscripcion
     */
    void save(Inscripcion inscripcion);

    /**
     * Update.
     *
     * @param inscripcion
     *            the inscripcion
     */
    void update(Inscripcion inscripcion);

    /**
     * Delete.
     *
     * @param inscripcion
     *            the inscripcion
     */
    void delete(Inscripcion inscripcion);

}
