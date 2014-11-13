package com.metodologias.rampa.service;

import com.metodologias.rampa.model.Alumno;

/**
 * The Interface SocioService.
 */
public interface AlumnoService {

    /**
     * Save.
     *
     * @param alumno
     *            the alumno
     */
    void save(Alumno alumno);

    /**
     * Update.
     *
     * @param alumno
     *            the alumno
     */
    void update(Alumno alumno);

    /**
     * Delete.
     *
     * @param alumno
     *            the alumno
     */
    void delete(Alumno alumno);

    /**
     * Find by id.
     *
     * @param id
     *            the id
     * @return the alumno
     */
    Alumno findById(final Long id);

}
