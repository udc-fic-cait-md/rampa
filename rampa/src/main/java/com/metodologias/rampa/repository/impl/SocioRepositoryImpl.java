package com.metodologias.rampa.repository.impl;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.metodologias.rampa.model.Socio;
import com.metodologias.rampa.repository.SocioRepository;
import com.metodologias.rampa.util.CustomHibernateDaoSupport;

/**
 * The Class SocioRepositoryImpl.
 */
@Repository("socioRepository")
public class SocioRepositoryImpl extends CustomHibernateDaoSupport implements SocioRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Socio socio) {
        getHibernateTemplate().save(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Socio socio) {
        getHibernateTemplate().update(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Socio socio) {
        getHibernateTemplate().delete(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Socio findByNumero(final Long numeroSocio) {
        final Socio socio = (Socio) DataAccessUtils.uniqueResult(getHibernateTemplate().find(
                "from Socio where numero=?", numeroSocio));
        return socio;
    }

}
