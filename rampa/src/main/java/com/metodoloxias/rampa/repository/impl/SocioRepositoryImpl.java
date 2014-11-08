package com.metodoloxias.rampa.repository.impl;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.metodoloxias.rampa.model.Socio;
import com.metodoloxias.rampa.repository.SocioRepository;
import com.metodoloxias.rampa.util.CustomHibernateDaoSupport;

@Repository("socioRepository")
public class SocioRepositoryImpl extends CustomHibernateDaoSupport implements SocioRepository {

	@Override
	public void save(Socio socio) {
		getHibernateTemplate().save(socio);
	}

	@Override
	public void update(Socio socio) {
		getHibernateTemplate().update(socio);
	}

	@Override
	public void delete(Socio socio) {
		getHibernateTemplate().delete(socio);
	}

	@Override
	public Socio findByNumero(Long numeroSocio) {
		Socio socio = (Socio) DataAccessUtils
				.uniqueResult(getHibernateTemplate().find(
                "from Socio where numero=?",numeroSocio));
		return socio;
	}

}
