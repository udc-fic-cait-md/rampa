package com.metodologias.rampa.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metodologias.rampa.model.Inscripcion;
import com.metodologias.rampa.repository.InscripcionRepository;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class InscripcionRepositoryImpl.
 */
@Repository(CommonNaming.BEAN_REPOSITORIO_INSCRIPCION)
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Inscripcion findById(final Long id) {
        final Query query = this.sessionFactory.getCurrentSession().createQuery("from Inscripcion where id=:id");
        query.setParameter("id", id);
        final List<Inscripcion> list = query.list();
        return list != null ? list.get(CommonNaming.POSICION_INICIAL) : null;
    }

}
