package com.metodoloxias.rampa.repository;

import com.metodoloxias.rampa.model.Inscripcion;

public interface InscripcionRepository {

	void save(Inscripcion inscripcion);
	void update(Inscripcion inscripcion);
	void delete(Inscripcion inscripcion);
	
}