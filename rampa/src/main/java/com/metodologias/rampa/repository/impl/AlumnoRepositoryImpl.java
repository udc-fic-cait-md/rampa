package com.metodologias.rampa.repository.impl;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.repository.AlumnoRepository;
import com.metodologias.rampa.util.CustomHibernateDaoSupport;

/**
 * The Class AlumnoRepositoryImpl.
 */
@Repository("alumnoRepository")
public class AlumnoRepositoryImpl extends CustomHibernateDaoSupport implements AlumnoRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final Alumno alumno) {
        getHibernateTemplate().save(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Alumno alumno) {
        getHibernateTemplate().update(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Alumno alumno) {
        getHibernateTemplate().delete(alumno);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Alumno findById(final Long id) {
        final Alumno alumno = (Alumno) DataAccessUtils.uniqueResult(getHibernateTemplate().find(
                "from Alumno where id=?", id));
        return alumno;
    }

}
