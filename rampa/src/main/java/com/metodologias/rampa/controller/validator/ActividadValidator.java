package com.metodologias.rampa.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.service.ActividadService;

/**
 * The Class ActividadValidator.
 */
@Component
public class ActividadValidator implements Validator {

    /** The msg source. */
    @Autowired
    private MessageSource msgSource;

    /** The actividad service. */
    @Autowired
    private ActividadService actividadService;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(final Class clazz) {
        return Actividad.class.isAssignableFrom(clazz);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(final Object target, final Errors errors) {

        // Validaciones de los campos de la actividad
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "actividad.nombreObligatorio",
                "El nombre de la actividad es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigo", "actividad.codigoObligatorio",
                "El c\u00F3digo de la actividad es obligatorio");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cuota","actividad.cuotaObligatoria",
        // "El campo cuota es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaInicio", "actividad.fechaInicioObligatoria",
                "La fecha de inicio de la actividad es obligatoria");

        final Actividad actividad = (Actividad) target;

        if (actividad.getCodigo() != null && actividad.getCodigo().length() > 10) {
            errors.rejectValue("codigo", "actividad.codigoMayorPermitido",
                    "El código no puede superar los 10 caracteres");
        }

        // Validaciones sobre el objeto actividad

        /*
         * if(actividad.getCodigo()!= null){
         * 
         * if(actividadService.findByCodigoActividad(actividad.getCodigo())!= null){
         * errors.rejectValue("codigo","actividad.codigoRepetido", "El c\u00F3digo de la actividad ya existe"); }
         * 
         * }
         */

    }

}
