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

    /**
     * Find by id.
     *
     * @param id
     *            the id
     * @return the inscripcion
     */
    Inscripcion findById(Long id);

    /**
     * Find all.
     *
     * @return the list
     */
	Object findAll();

}
