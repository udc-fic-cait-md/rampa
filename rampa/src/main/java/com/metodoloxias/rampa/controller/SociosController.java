package com.metodoloxias.rampa.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.metodoloxias.rampa.model.Socio;

@Controller
@RequestMapping(value = "/socios")
public class SociosController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView cargarListadoSocios() {
		
		ModelAndView modelo = new ModelAndView("socios/socios");
		
	    return modelo;
	}
	
	@RequestMapping(value = "/alta", method = RequestMethod.GET)
	public ModelAndView cargarAltaSocio(Model model) {
		ModelAndView modelo = new ModelAndView("socios/alta_socio");
		model.addAttribute("nuevoSocio", new Socio());
	    return modelo;
	}
	
	@RequestMapping(value = "/perfil/{idSocio}", method = RequestMethod.GET)
	public ModelAndView cargarPerfilSocio(@PathVariable("idSocio") Integer idSocio) {
		
		ModelAndView modelo = new ModelAndView("socios/ficha_socio");
		
		// modelo.addObject("idSocio", idSocio);
		
	    return modelo;
	}
	
	@RequestMapping(value = "/darAltaSocio", method = RequestMethod.POST)
	public ModelAndView altaSocio(@Valid @ModelAttribute("nuevoSocio") Socio nuevoSocio, BindingResult result, Model model) {
		if (!result.hasErrors()){
//			getServicioSocio().darAltaSocio(nuevoSocio);
//			Locale locale = LocaleContextHolder.getLocale();
//			getMsgSource().getMessage(key, null, locale);
			model.addAttribute("infoMsg", "Socio dado de alta satisfactoriamente");
		}
		ModelAndView modelo = new ModelAndView("socios/alta_socio");
		return modelo;
	}

}