package com.metodologias.rampa.repository;

import java.util.List;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.model.Alumno;

/**
 * The Interface AlumnoRepository.
 */
public interface AlumnoRepository {

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
    Alumno findById(Long id);

	List<Alumno> findAll();

}