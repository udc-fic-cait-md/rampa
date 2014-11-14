package com.metodologias.rampa.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.repository.ActividadRepository;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class ActividadRepositoryImpl.
 */
@Repository(CommonNaming.BEAN_REPOSITORIO_ACTIVIDAD)
@Transactional
public class ActividadRepositoryImpl implements ActividadRepository {

    /** The session factory. */
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Actividad actividad) {
        this.sessionFactory.getCurrentSession().save(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Actividad actividad) {
        this.sessionFactory.getCurrentSession().update(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Actividad actividad) {
        this.sessionFactory.getCurrentSession().delete(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Actividad findByCodigoActividad(final String codigoActividad) {
        final Query query = this.sessionFactory.getCurrentSession().createQuery("from Actividad where codigo=:codigo");
        query.setParameter("codigo", codigoActividad);
        final List<Actividad> list = query.list();
        return list != null ? list.get(CommonNaming.POSICION_INICIAL) : null;
    }

}
