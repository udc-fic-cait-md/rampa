package com.metodologias.rampa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodologias.rampa.model.Inscripcion;
import com.metodologias.rampa.repository.InscripcionRepository;
import com.metodologias.rampa.service.InscripcionService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class InscripcionServiceImpl.
 */
@Service(CommonNaming.BEAN_SERVICIO_INSCRIPCION)
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Inscripcion findById(final Long id) {
        return this.inscripcionRepository.findById(id);
    }

	@Override
	public Object findAll() {
		return this.inscripcionRepository.findAll();
	}

}
