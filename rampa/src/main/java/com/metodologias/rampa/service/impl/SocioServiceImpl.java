package com.metodologias.rampa.service.impl;

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

    
    public SocioRepository getSocioRepository() {
		return socioRepository;
	}

	public void setSocioRepository(SocioRepository socioRepository) {
		this.socioRepository = socioRepository;
	}

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

}
