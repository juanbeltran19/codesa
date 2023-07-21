/**
 * Empresa: Codesa
 * Clase:   RepositorioUsuario
 * fecha:	20/07/2023
 * @author Juan Pablo Beltran
 */
package com.codesa.repositorio;

import com.codesa.modelo.Usuario;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface permite operaciones crud sobre
 *  la tabla usuario en la base de datos 
 */
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>{

}
