package com.metodoloxias.rampa.repository.impl;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.metodoloxias.rampa.model.Actividad;
import com.metodoloxias.rampa.repository.ActividadRepository;
import com.metodoloxias.rampa.util.CustomHibernateDaoSupport;

@Repository("actividadRepository")
public class ActividadRepositoryImpl extends CustomHibernateDaoSupport implements ActividadRepository {

	@Override
	public void save(Actividad actividad) {
		getHibernateTemplate().save(actividad);
	}

	@Override
	public void update(Actividad actividad) {
		getHibernateTemplate().update(actividad);
	}

	@Override
	public void delete(Actividad actividad) {
		getHibernateTemplate().delete(actividad);
	}

	@Override
	public Actividad findByCodigoActividad(String codigoActividad) {
		Actividad actividad = (Actividad) DataAccessUtils
				.uniqueResult(getHibernateTemplate().find(
                "from Actividad where codigo=?",codigoActividad));
	return actividad;
	}

}
