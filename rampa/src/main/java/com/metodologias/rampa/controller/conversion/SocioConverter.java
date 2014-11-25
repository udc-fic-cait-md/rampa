package com.metodologias.rampa.controller.conversion;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metodologias.rampa.model.Socio;
import com.metodologias.rampa.service.SocioService;

/**
 * The Class SocioConverter.
 */
@Component
public class SocioConverter extends PropertyEditorSupport {

    /** The socio service. */
    @Autowired
    private SocioService socioService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAsText(final String text) {
        try {
            final Socio socio = this.socioService.findByNumero(Long.valueOf(text));

            setValue(socio);
        } catch (final Exception e) {

        }
    }
}
