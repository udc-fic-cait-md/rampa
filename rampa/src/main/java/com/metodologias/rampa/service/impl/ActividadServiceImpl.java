package com.metodologias.rampa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.repository.ActividadRepository;
import com.metodologias.rampa.service.ActividadService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class ActividadServiceImpl.
 */
@Service(CommonNaming.BEAN_SERVICIO_ACTIVIDAD)
public class ActividadServiceImpl implements ActividadService {

    /** The actividad repository. */
    @Autowired
    private ActividadRepository actividadRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Actividad actividad) {
        this.actividadRepository.save(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Actividad actividad) {
        this.actividadRepository.update(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Actividad actividad) {
        this.actividadRepository.delete(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Actividad findByCodigoActividad(final String codigoActividad) {
        return this.actividadRepository.findByCodigoActividad(codigoActividad);
    }

}
