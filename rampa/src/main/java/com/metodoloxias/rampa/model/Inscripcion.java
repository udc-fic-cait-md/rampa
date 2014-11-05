package com.metodoloxias.rampa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date fechaAlta;
	private Date fechaBaja;
	private boolean pagoAlDia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALUMNO_ID")
	private Alumno alumno;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACTIVIDAD_ID")
	private Actividad actividad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public boolean isPagoAlDia() {
		return pagoAlDia;
	}

	public void setPagoAlDia(boolean pagoAlDia) {
		this.pagoAlDia = pagoAlDia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
}
