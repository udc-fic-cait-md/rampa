package com.metodoloxias.rampa.repository.impl;

import org.springframework.stereotype.Repository;

import com.metodoloxias.rampa.model.Alumno;
import com.metodoloxias.rampa.repository.AlumnoRepository;
import com.metodoloxias.rampa.util.CustomHibernateDaoSupport;

@Repository("alumnoRepository")
public class AlumnoRepositoryImpl extends CustomHibernateDaoSupport implements AlumnoRepository {

	@Override
	public void save(Alumno alumno) {
		getHibernateTemplate().save(alumno);
	}

	@Override
	public void update(Alumno alumno) {
		getHibernateTemplate().update(alumno);
	}

	@Override
	public void delete(Alumno alumno) {
		getHibernateTemplate().delete(alumno);
	}

}
