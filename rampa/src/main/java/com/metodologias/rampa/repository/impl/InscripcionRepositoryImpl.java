package com.metodologias.rampa.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metodologias.rampa.model.Inscripcion;
import com.metodologias.rampa.repository.InscripcionRepository;

/**
 * The Class InscripcionRepositoryImpl.
 */
@Repository("inscripcionRepository")
@Transactional
public class InscripcionRepositoryImpl implements InscripcionRepository {

    /** The session factory. */
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Inscripcion inscripcion) {
        this.sessionFactory.getCurrentSession().save(inscripcion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Inscripcion inscripcion) {
        this.sessionFactory.getCurrentSession().update(inscripcion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Inscripcion inscripcion) {
        this.sessionFactory.getCurrentSession().delete(inscripcion);
    }

}
