/**
 * Empresa: Codesa
 * Clase:   Usuario
 * fecha:	20/07/2023
 * @author Juan Pablo Beltran
 */
package com.codesa.modelo;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Esta clase es el modelo de Usuario
 */
@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@Column(name="idusuario")
	private int idusuario;

	@Column(name="idrol")
	private int idrol;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="activo")
	private String activo;

	@Column(name="correo")
	private String correo;

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

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

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}	
	
}
