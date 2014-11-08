package com.metodoloxias.rampa.repository;

import com.metodoloxias.rampa.model.Socio;

public interface SocioRepository {

	void save(Socio socio);
	void update(Socio socio);
	void delete(Socio socio);
	Socio findByNumero(Long numeroSocio);
	
}