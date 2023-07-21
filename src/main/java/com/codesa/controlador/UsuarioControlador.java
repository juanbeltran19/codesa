/**
 * Empresa: Codesa
 * Clase:   UsuarioControlador
 * fecha:	20/07/2023
 * @author Juan Pablo Beltran
 */
package com.codesa.controlador;

import com.codesa.modelo.Usuario;

import com.codesa.repositorio.RepositorioUsuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;
/**
 * Esta clase es la api de usuario 
 */
@RestController
@RequestMapping("/api")
public class UsuarioControlador {

	private final Logger LOOGER = LoggerFactory.getLogger(RolControlador.class);

	@Autowired
	RepositorioUsuario repositorioUsuario;
	
	/**
	 * Este metodo devuelve la lista de usuarios 
	 * @return Iterable<Usuario> listarUsuarios 
	 */
	@GetMapping(path="/usuarios")
	public @ResponseBody Iterable<Usuario> listarUsuarios(){
		LOOGER.debug("Listar Usuarios: ", repositorioUsuario.findAll());
		return repositorioUsuario.findAll();
	}
	
	/**
	 * Este metodo permite crear los usuarios
	 * @param Usuario usuarios parametro de tipo Usuario
	 * @return String mensaje
	 */
	@PostMapping("/usuarios/crear")
	public String crearUsuarios(@RequestBody Usuario usuarios) {
		try {
			Usuario usuario = new Usuario();
			usuario.setIdrol(usuarios.getIdrol());
			usuario.setNombre(usuarios.getNombre());
			usuario.setActivo(usuarios.getActivo());
			usuario.setCorreo(usuarios.getCorreo());
			repositorioUsuario.save(usuario);
			LOOGER.debug("Crear Usuarios:", usuarios);
		}catch(Exception e) {
			LOOGER.error("Error crearUsuarios: "+e.getMessage());
		}				
		return "Usuario Creado Correctamente";
	}
	
	/**
	 * Este metodo permite buscar y devolver un usuario 
	 * @param int id parametro id usuario
	 * @return Optional<Usuario> informacion del usuario
	 */	
	@GetMapping("/usuarios/consultar/{id}")
	@ResponseBody
	public Optional<Usuario> consultarUsuario(@PathVariable("id") int id) {
		LOOGER.debug("Consultar Usuario:", repositorioUsuario.findById(id));
		return repositorioUsuario.findById(id);
	}
	
	/**
	 * Este metodo permite eliminar un usuario
	 * @param int id parametro identificacion usuario
	 * @return String mensaje
	 */	
	@PostMapping("/usuarios/eliminar/{id}")
	@ResponseBody
	public String eliminarUsuario(@PathVariable("id") int id) {
		try {
			Usuario usuario = new Usuario();
			usuario.setIdusuario(id);
			repositorioUsuario.delete(usuario);
			LOOGER.debug("Eliminar Usuario:", usuario);
		}catch(Exception e) {
			LOOGER.error("Error eliminarUsuario: "+e.getMessage());
		}
		return "Usuario eliminado";
	}
	
	/**
	 * Este metodo permite actualizar la informacion de un usuario
	 * @param Usuario parametro informacion usuario
	 * @param int id parametro identificacion usuario
	 * @return String mensaje
	 */	
	@PutMapping("/usuarios/actualizar/{id}")
	public String actualizarUsuario(@RequestBody Usuario usuarios, @PathVariable("id") int id) {
		try {
			Usuario usuario = new Usuario();
			Optional<Usuario> aux = repositorioUsuario.findById(id);
			Usuario usuarioObj = aux.get();
			usuario.setIdusuario(usuarioObj.getIdusuario());
			usuario.setIdrol(usuarios.getIdrol());
			usuario.setNombre(usuarios.getNombre());
			usuario.setActivo(usuarios.getActivo());
			usuario.setCorreo(usuarios.getCorreo());
			repositorioUsuario.save(usuario);
			LOOGER.debug("Actualizar Usuario", usuario);
		}catch(Exception e) {
			LOOGER.error("Error actualizarUsuario: "+e.getMessage());
		}	
		return "Usuario actualizado correctamente";
	}	
}
