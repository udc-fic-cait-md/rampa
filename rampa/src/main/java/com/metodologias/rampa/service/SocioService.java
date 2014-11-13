package com.metodologias.rampa.service;

import com.metodologias.rampa.model.Socio;

/**
 * The Interface SocioService.
 */
public interface SocioService {

    /**
     * Save.
     *
     * @param socio
     *            the socio
     */
    void save(Socio socio);

    /**
     * Update.
     *
     * @param socio
     *            the socio
     */
    void update(Socio socio);

    /**
     * Delete.
     *
     * @param socio
     *            the socio
     */
    void delete(Socio socio);

    /**
     * Find by numero.
     *
     * @param numeroSocio
     *            the numero socio
     * @return the socio
     */
    Socio findByNumero(Long numeroSocio);

}
