package com.metodologias.rampa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodologias.rampa.model.Socio;
import com.metodologias.rampa.repository.SocioRepository;
import com.metodologias.rampa.service.SocioService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class SocioServiceImpl.
 */
@Service(CommonNaming.BEAN_SERVICIO_SOCIO)
public class SocioServiceImpl implements SocioService {

    /** The socio repository. */
    @Autowired
    private SocioRepository socioRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Socio socio) {
        this.socioRepository.save(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Socio socio) {
        this.socioRepository.update(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Socio socio) {
        this.socioRepository.delete(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Socio findByNumero(final Long numeroSocio) {
        return this.socioRepository.findByNumero(numeroSocio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Socio> findAll() {
        return this.socioRepository.findAll();
    }

    /**
     * Gets the socio repository.
     *
     * @return the socio repository
     */
    public SocioRepository getSocioRepository() {
        return this.socioRepository;
    }

    /**
     * Sets the socio repository.
     *
     * @param socioRepository
     *            the new socio repository
     */
    public void setSocioRepository(final SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

}
