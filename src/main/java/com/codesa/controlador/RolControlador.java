/**
 * Empresa: Codesa
 * Clase:   RolControlador
 * fecha:	20/07/2023
 * @author Juan Pablo Beltran
 */
package com.codesa.controlador;

import com.codesa.modelo.Rol;

import com.codesa.repositorio.RepositorioRol;

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
 * Esta clase es la api de rol 
 */
@RestController
@RequestMapping("/api")
public class RolControlador {
	
	private final Logger LOOGER = LoggerFactory.getLogger(RolControlador.class);

	@Autowired
	RepositorioRol repositorioRol;
	
	/**
	 * Este metodo devuelve la lista de rol 
	 * @return Iterable<Rol> listarRoles 
	 */
	@GetMapping(path="/roles")
	public @ResponseBody Iterable<Rol> listarRoles(){
		LOOGER.debug("Listar Roles: ", repositorioRol.findAll());
		return repositorioRol.findAll();
	}	

	/**
	 * Este metodo permite crear los roles
	 * @param Rol roles parametro de tipo Rol
	 * @return String mensaje
	 */
	@PostMapping("/roles/crear")
	public String crearRol(@RequestBody Rol roles) {
		try {
			Rol rol = new Rol();
			rol.setIdrol(roles.getIdrol());
			rol.setNombre(roles.getNombre());
			repositorioRol.save(rol);
			LOOGER.debug("Crear Roles:", roles);
		}catch(Exception e) {
			LOOGER.error("Error crearRol: "+e.getMessage());
		}				
		return "Rol Creado Correctamente";
	}
	
	/**
	 * Este metodo permite buscar y devolver un rol 
	 * @param int id parametro id rol
	 * @return Optional<Rol> informacion del rol
	 */	
	@GetMapping("/roles/consultar/{id}")
	@ResponseBody
	public Optional<Rol> consultarRol(@PathVariable("id") int id) {
		LOOGER.debug("Consultar Rol:", repositorioRol.findById(id));
		return repositorioRol.findById(id);
	}
	
	/**
	 * Este metodo permite eliminar un rol
	 * @param int id parametro identificacion rol
	 * @return String mensaje
	 */	
	@PostMapping("/roles/eliminar/{id}")
	@ResponseBody
	public String eliminarRol(@PathVariable("id") int id) {
		try {
			Rol rol = new Rol();
			rol.setIdrol(id);
			repositorioRol.delete(rol);
			LOOGER.debug("Eliminar Rol:", rol);
		}catch(Exception e) {
			LOOGER.error("Error eliminarRol: "+e.getMessage());
		}
		return "Rol eliminado";
	}
	
	/**
	 * Este metodo permite actualizar la informacion de un rol
	 * @param Rol parametro informacion rol
	 * @param int id parametro identificacion rol
	 * @return String mensaje
	 */	
	@PutMapping("/roles/actualizar/{id}")
	public String actualizarRol(@RequestBody Rol roles, @PathVariable("id") int id) {
		try {
			Rol rol = new Rol();
			Optional<Rol> aux = repositorioRol.findById(id);
			Rol rolObj = aux.get();
			rol.setIdrol(rolObj.getIdrol());
			rol.setNombre(roles.getNombre());
			repositorioRol.save(rol);
			LOOGER.debug("Actualizar Rol", rol);
		}catch(Exception e) {
			LOOGER.error("Error actualizarRol: "+e.getMessage());
		}	
		return "Rol actualizado correctamente";
	}	
}
