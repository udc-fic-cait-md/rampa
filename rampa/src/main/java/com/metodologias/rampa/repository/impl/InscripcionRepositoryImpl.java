package com.metodologias.rampa.repository.impl;

import org.springframework.stereotype.Repository;

import com.metodologias.rampa.model.Inscripcion;
import com.metodologias.rampa.repository.InscripcionRepository;
import com.metodologias.rampa.util.CustomHibernateDaoSupport;

/**
 * The Class InscripcionRepositoryImpl.
 */
@Repository("inscripcionRepository")
public class InscripcionRepositoryImpl extends CustomHibernateDaoSupport implements InscripcionRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Inscripcion inscripcion) {
        getHibernateTemplate().save(inscripcion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Inscripcion inscripcion) {
        getHibernateTemplate().update(inscripcion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Inscripcion inscripcion) {
        getHibernateTemplate().delete(inscripcion);
    }

}
