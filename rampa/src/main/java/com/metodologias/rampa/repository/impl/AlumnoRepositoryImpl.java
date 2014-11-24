package com.metodologias.rampa.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.repository.AlumnoRepository;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class AlumnoRepositoryImpl.
 */
@Repository(CommonNaming.BEAN_REPOSITORIO_ALUMNO)
@Transactional
public class AlumnoRepositoryImpl implements AlumnoRepository {

    /** The session factory. */
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Alumno alumno) {
        this.sessionFactory.getCurrentSession().save(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Alumno alumno) {
        this.sessionFactory.getCurrentSession().update(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Alumno alumno) {
        this.sessionFactory.getCurrentSession().delete(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Alumno findById(final Long id) {
        final Query query = this.sessionFactory.getCurrentSession().createQuery("from Alumno where id=:id");
        query.setParameter("id", id);
        final List<Alumno> list = query.list();
        return list != null ? list.get(CommonNaming.POSICION_INICIAL) : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Alumno> findAll() {
        final Query query = this.sessionFactory.getCurrentSession().createQuery("from Alumno");
        final List<Alumno> list = query.list();
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
