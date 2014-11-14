package com.metodologias.rampa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.repository.AlumnoRepository;
import com.metodologias.rampa.service.AlumnoService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class AlumnoServiceImpl.
 */
@Service(CommonNaming.BEAN_SERVICIO_ALUMNO)
public class AlumnoServiceImpl implements AlumnoService {

    /** The alumno repository. */
    @Autowired
    private AlumnoRepository alumnoRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Alumno alumno) {
        this.alumnoRepository.save(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Alumno alumno) {
        this.alumnoRepository.update(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Alumno alumno) {
        this.alumnoRepository.delete(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Alumno findById(final Long id) {
        return this.alumnoRepository.findById(id);
    }

}
