/**
 * Empresa: Codesa
 * Clase:   Rol
 * fecha:	20/07/2023
 * @author Juan Pablo Beltran
 */
package com.codesa.modelo;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Esta clase es el modelo de Rol
 */
@Entity
@Table(name="rol")
public class Rol {
	
	@Id
	@Column(name="idrol")
	private int idrol;

	@Column(name="nombre")
	private String nombre;

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
