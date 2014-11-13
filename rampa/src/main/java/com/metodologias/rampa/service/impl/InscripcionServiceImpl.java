package com.metodologias.rampa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodologias.rampa.model.Inscripcion;
import com.metodologias.rampa.repository.InscripcionRepository;
import com.metodologias.rampa.service.InscripcionService;

/**
 * The Class InscripcionServiceImpl.
 */
@Service("inscripcionService")
public class InscripcionServiceImpl implements InscripcionService {

    /** The inscripcion repository. */
    @Autowired
    private InscripcionRepository inscripcionRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Inscripcion inscripcion) {
        this.inscripcionRepository.save(inscripcion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Inscripcion inscripcion) {
        this.inscripcionRepository.update(inscripcion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Inscripcion inscripcion) {
        this.inscripcionRepository.delete(inscripcion);
    }

}
