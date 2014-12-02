package com.metodologias.rampa.controller.conversion;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.service.ActividadService;

/**
 * The Class ActividadConverter.
 */
@Component
public class ActividadConverter extends PropertyEditorSupport {

    /** The actividad service. */
    @Autowired
    private ActividadService actividadService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAsText(final String text) {
        try {
            final Actividad actividad = this.actividadService.findByCodigoActividad(text);

            setValue(actividad);
        } catch (final Exception e) {

        }
    }
}
