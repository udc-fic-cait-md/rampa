package com.metodologias.rampa.controller.conversion;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.service.AlumnoService;

/**
 * The Class AlumnoConverter.
 */
@Component
public class AlumnoConverter extends PropertyEditorSupport {

    /** The alumno service. */
    @Autowired
    private AlumnoService alumnoService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAsText(final String text) {
        try {
            final Alumno alumno = this.alumnoService.findById(Long.valueOf(text));

            setValue(alumno);
        } catch (final Exception e) {

        }
    }
}
