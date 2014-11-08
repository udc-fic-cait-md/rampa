package com.metodoloxias.rampa.repository;

import com.metodoloxias.rampa.model.Actividad;

public interface ActividadRepository {

	void save(Actividad actividad);
	void update(Actividad actividad);
	void delete(Actividad actividad);
	Actividad findByCodigoActividad(String codigoActividad);
	
}