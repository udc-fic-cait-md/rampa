package com.metodologias.rampa.repository.impl;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.repository.ActividadRepository;
import com.metodologias.rampa.util.CustomHibernateDaoSupport;

/**
 * The Class ActividadRepositoryImpl.
 */
@Repository("actividadRepository")
public class ActividadRepositoryImpl extends CustomHibernateDaoSupport implements ActividadRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Actividad actividad) {
        getHibernateTemplate().save(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Actividad actividad) {
        getHibernateTemplate().update(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Actividad actividad) {
        getHibernateTemplate().delete(actividad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Actividad findByCodigoActividad(final String codigoActividad) {
        final Actividad actividad = (Actividad) DataAccessUtils.uniqueResult(getHibernateTemplate().find(
                        "from Actividad where codigo=?", codigoActividad));
        return actividad;
    }

}
