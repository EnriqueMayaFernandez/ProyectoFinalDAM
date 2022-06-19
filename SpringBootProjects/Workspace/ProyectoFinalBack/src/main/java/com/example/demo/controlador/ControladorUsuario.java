package com.example.demo.controlador;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.servicios.ServicioUsuario;
import com.example.demo.servicios.dto.MensajeDTO;
import com.example.demo.servicios.dto.usuario.ListadoUsuariosDTO;
import com.example.demo.servicios.dto.usuario.LoginDTO;
import com.example.demo.servicios.dto.usuario.UsuarioDTO;
import com.example.demo.utilidades.excepciones.EntidadExiste;
import com.example.demo.utilidades.excepciones.ErrorLogin;



@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

	@Autowired
	ServicioUsuario servicioUsuario;

	@PostMapping("/insertar")
	public ResponseEntity<MensajeDTO> insertarUsuario(@RequestBody UsuarioDTO entrada) throws Exception {
		MensajeDTO salida=new MensajeDTO();
		try {
			salida.setMensaje("El usuario se ha insertado en la base de datos con exito");
			servicioUsuario.insertarUsuario(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (EntidadExiste e) {
			salida.setMensaje("Error al insertar el usuario en la base de datos ya que el nombre del usuario ya existe");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de insertar el usuario en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modificar")
	public ResponseEntity<MensajeDTO> modificarPelicula(@RequestBody UsuarioDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		try {
			salida.setMensaje("El usuario se ha modificado con exito");
			servicioUsuario.modificarUsuario(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("No se encuentra el usuario que se quiere modificar en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de modificar el usuario en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<MensajeDTO> borrarPelicula(@PathVariable int id) {
		MensajeDTO salida=new MensajeDTO();
		try {
			salida.setMensaje("El usuario se ha borrado corretamente");
			servicioUsuario.borrarUsuario(id);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("El usuario que se quiere borrar no se encuentra en la base de datos");
			return new ResponseEntity<MensajeDTO>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de borrar el usuario en la base de datos");
			return new ResponseEntity<MensajeDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-usuarios")
	public ResponseEntity<ListadoUsuariosDTO> getUsuarios() {
		ListadoUsuariosDTO salida = null;
		try {
			salida = servicioUsuario.getUsuarios();
			salida.setMensaje("Se han recuperado los usuarios correctamente");
			return new ResponseEntity<ListadoUsuariosDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inesperado en la recuperacion de los usuarios");
			return new ResponseEntity<ListadoUsuariosDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/logeo")
	public ResponseEntity<LoginDTO> logeoUsuario(@RequestBody UsuarioDTO entrada) {
		LoginDTO usuarioLogeado=null;
		try {
			usuarioLogeado = servicioUsuario.logeoUsuario(entrada);
			return new ResponseEntity<LoginDTO>(usuarioLogeado, HttpStatus.OK);
		} catch (ErrorLogin e) {
			return new ResponseEntity<LoginDTO>(usuarioLogeado, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/get-usuario/{id}")
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable long id) {
		UsuarioDTO salida = null;
		try {
			salida = servicioUsuario.getUsuario(id);
			return new ResponseEntity<UsuarioDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<UsuarioDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
