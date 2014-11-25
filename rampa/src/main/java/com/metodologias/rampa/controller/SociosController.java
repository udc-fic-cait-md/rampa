package com.metodologias.rampa.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class SociosController.
 */
@Controller
@RequestMapping(value = "/socios")
public class SociosController {

    /** The socio service. */
    @Autowired
    private SocioService socioService;

    /** The msg source. */
    @Autowired
    private MessageSource msgSource;

    /**
     * Cargar listado socios.
     *
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarListadoSocios() {
    	final ModelAndView modelo = new ModelAndView("socios/socios");
        List<Socio> listaSocios = socioService.findAll();
        modelo.addObject("listaSocios", listaSocios);
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
    @RequestMapping(value = "/perfil/{numSocio}", method = RequestMethod.GET)
    public ModelAndView cargarPerfilSocio(@PathVariable("numSocio") final Long numSocio) {
    	final ModelAndView modelo = new ModelAndView("socios/ficha_socio");
        modelo.addObject("socio", socioService.findByNumero(numSocio));
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
            this.socioService.save(nuevoSocio);
            model.addAttribute("infoMsg",
                    this.msgSource.getMessage(CommonNaming.ALTA_CORRECTA_SOCIO, null, Locale.getDefault()));
        }
        final ModelAndView modelo = new ModelAndView("socios/alta_socio");
        return modelo;
    }

    /**
     * Gets the socio service.
     *
     * @return the socio service
     */
    public SocioService getSocioService() {
        return this.socioService;
    }

    /**
     * Sets the socio service.
     *
     * @param socioService
     *            the new socio service
     */
    public void setSocioService(final SocioService socioService) {
        this.socioService = socioService;
    }

    /**
     * Gets the msg source.
     *
     * @return the msg source
     */
    public MessageSource getMsgSource() {
        return this.msgSource;
    }

    /**
     * Sets the msg source.
     *
     * @param msgSource
     *            the new msg source
     */
    public void setMsgSource(final MessageSource msgSource) {
        this.msgSource = msgSource;
    }

}