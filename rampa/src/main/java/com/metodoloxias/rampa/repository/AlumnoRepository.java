package com.metodoloxias.rampa.repository;

import com.metodoloxias.rampa.model.Alumno;

public interface AlumnoRepository {

	void save(Alumno alumno);
	void update(Alumno alumno);
	void delete(Alumno alumno);
	
}