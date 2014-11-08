package com.metodoloxias.rampa.repository.impl;

import org.springframework.stereotype.Repository;

import com.metodoloxias.rampa.model.Inscripcion;
import com.metodoloxias.rampa.repository.InscripcionRepository;
import com.metodoloxias.rampa.util.CustomHibernateDaoSupport;

@Repository("inscripcionRepository")
public class InscripcionRepositoryImpl extends CustomHibernateDaoSupport implements InscripcionRepository {

	@Override
	public void save(Inscripcion inscripcion) {
		getHibernateTemplate().save(inscripcion);
	}

	@Override
	public void update(Inscripcion inscripcion) {
		getHibernateTemplate().update(inscripcion);
	}

	@Override
	public void delete(Inscripcion inscripcion) {
		getHibernateTemplate().delete(inscripcion);
	}

}
