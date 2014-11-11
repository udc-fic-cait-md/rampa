package com.metodologias.rampa.repository;

import com.metodologias.rampa.model.Inscripcion;

/**
 * The Interface InscripcionRepository.
 */
public interface InscripcionRepository {

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