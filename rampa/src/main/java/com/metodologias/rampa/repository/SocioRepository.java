package com.metodologias.rampa.repository;

import java.util.List;

import com.metodologias.rampa.model.Socio;

/**
 * The Interface SocioRepository.
 */
public interface SocioRepository {

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

    /**
     * Find all.
     *
     * @return the list
     */
    List<Socio> findAll();
}