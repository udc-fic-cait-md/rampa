package com.metodologias.rampa.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metodologias.rampa.model.Socio;
import com.metodologias.rampa.repository.SocioRepository;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class SocioRepositoryImpl.
 */
@Repository(CommonNaming.BEAN_REPOSITORIO_SOCIO)
@Transactional
public class SocioRepositoryImpl implements SocioRepository {

    /** The session factory. */
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Socio socio) {
        this.sessionFactory.getCurrentSession().save(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Socio socio) {
        this.sessionFactory.getCurrentSession().update(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Socio socio) {
        this.sessionFactory.getCurrentSession().delete(socio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Socio findByNumero(final Long numeroSocio) {
        final Query query = this.sessionFactory.getCurrentSession().createQuery("from Socio where numero=:numero");
        query.setParameter("numero", numeroSocio);
        final List<Socio> list = query.list();
        return list != null ? list.get(CommonNaming.POSICION_INICIAL) : null;
    }
}
