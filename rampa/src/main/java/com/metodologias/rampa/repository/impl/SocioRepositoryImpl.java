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
    @Autowired
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Socio> findAll() {
        final Query query = this.sessionFactory.getCurrentSession().createQuery("from Socio");
        final List<Socio> list = query.list();
        return list;
    }

    /**
     * Gets the session factory.
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    /**
     * Sets the session factory.
     *
     * @param sessionFactory
     *            the new session factory
     */
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
