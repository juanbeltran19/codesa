/**
 * Empresa: Codesa
 * Clase:   RepositorioRol
 * fecha:	20/07/2023
 * @author Juan Pablo Beltran
 */
package com.codesa.repositorio;

import com.codesa.modelo.Rol;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface permite operaciones crud sobre
 *  la tabla rol en la base de datos 
 */
@Repository
public interface RepositorioRol extends JpaRepository<Rol, Integer>{

}
