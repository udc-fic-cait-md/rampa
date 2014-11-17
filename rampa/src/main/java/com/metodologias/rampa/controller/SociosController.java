package com.metodologias.rampa.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metodologias.rampa.model.Socio;
import com.metodologias.rampa.service.SocioService;

/**
 * The Class SociosController.
 */
@Controller
@RequestMapping(value = "/socios")
public class SociosController {

	@Autowired
	SocioService socioService;
	
	public SocioService getSocioService() {
		return socioService;
	}

	public void setSocioService(SocioService socioService) {
		this.socioService = socioService;
	}
	
	@Autowired
	MessageSource msgSource;

	public MessageSource getMsgSource() {
		return msgSource;
	}

	public void setMsgSource(MessageSource msgSource) {
		this.msgSource = msgSource;
	}
	
    /**
     * Cargar listado socios.
     *
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarListadoSocios() {
        final ModelAndView modelo = new ModelAndView("socios/socios");
        return modelo;
    }

    /**
     * Cargar alta socio.
     *
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = "/alta", method = RequestMethod.GET)
    public ModelAndView cargarAltaSocio(final Model model) {
        final ModelAndView modelo = new ModelAndView("socios/alta_socio");
        model.addAttribute("nuevoSocio", new Socio());
        return modelo;
    }

    /**
     * Cargar perfil socio.
     *
     * @param idSocio
     *            the id socio
     * @return the model and view
     */
    @RequestMapping(value = "/perfil/{idSocio}", method = RequestMethod.GET)
    public ModelAndView cargarPerfilSocio(@PathVariable("idSocio") final Integer idSocio) {
        final ModelAndView modelo = new ModelAndView("socios/ficha_socio");

        // modelo.addObject("idSocio", idSocio);

        return modelo;
    }

    /**
     * Alta socio.
     *
     * @param nuevoSocio
     *            the nuevo socio
     * @param result
     *            the result
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = "/darAltaSocio", method = RequestMethod.POST)
    public ModelAndView altaSocio(@Valid @ModelAttribute("nuevoSocio") final Socio nuevoSocio,
            final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            getSocioService().save(nuevoSocio);
            Locale locale = LocaleContextHolder.getLocale();
            getMsgSource().getMessage("Socio dado de alta satisfactoriamente", null, locale);
            model.addAttribute("infoMsg", "Socio dado de alta satisfactoriamente");
        }
        final ModelAndView modelo = new ModelAndView("socios/alta_socio");
        return modelo;
    }

}