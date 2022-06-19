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

import com.example.demo.servicios.ServicioRelacionUsuarioPelicula;
import com.example.demo.servicios.dto.MensajeDTO;
import com.example.demo.servicios.dto.relaciones.usuarioPelicula.ListadoRelacionUsuarioPeliculaDTO;
import com.example.demo.servicios.dto.relaciones.usuarioPelicula.RelacionUsuarioPeliculaDTO;


@RestController
@RequestMapping("/relacion-usuario-pelicula")
public class ControladorRelacionUsuarioPelicula {
	
	@Autowired
	ServicioRelacionUsuarioPelicula servicioRelacionUsuarioPelicula;
	
	@PostMapping("/insertar")
	public ResponseEntity<MensajeDTO> insertarRelacionUsuarioPelicula(@RequestBody RelacionUsuarioPeliculaDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		try {
			salida.setMensaje("Se ha insertado el anime a su lista");
			servicioRelacionUsuarioPelicula.insertarRelacionUsuarioPelicula(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora insertar el anime en su lista");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<MensajeDTO> modificarRelacionUsuarioPelicula(@RequestBody RelacionUsuarioPeliculaDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		try {
			salida.setMensaje("La relacion se ha modificado con exito");
			servicioRelacionUsuarioPelicula.modificarRelacionUsuarioPelicula(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("No se encuentra la relacion que se quiere modificar en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de modificar la relacion en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<MensajeDTO> borrarRelacionUsuarioPelicula(@PathVariable long id) {
		MensajeDTO salida=new MensajeDTO();
		try {
			salida.setMensaje("La pelicula se ha borrado correctamente de su lista");
			servicioRelacionUsuarioPelicula.borrarRelacionUsuarioPelicula(id);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("El anime que se quiere borrar no se encuentra en la base de datos");
			return new ResponseEntity<MensajeDTO>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de borrar el anime");
			return new ResponseEntity<MensajeDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-relaciones-usuario-pelicula")
	public ResponseEntity<ListadoRelacionUsuarioPeliculaDTO> getRelacionesUsuarioPelicula() {
		ListadoRelacionUsuarioPeliculaDTO salida=null;
		try {
			salida = servicioRelacionUsuarioPelicula.getRelacionesUsuarioPelicula();
			salida.setMensaje("Se han recuperado los animes de su lista correctamente");
			return new ResponseEntity<ListadoRelacionUsuarioPeliculaDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inesperado en la recuperacion de los animes de su lista");
			return new ResponseEntity<ListadoRelacionUsuarioPeliculaDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-relacion-usuario-pelicula/{id}")
	public ResponseEntity<RelacionUsuarioPeliculaDTO> getRelacionUsuarioPelicula(@PathVariable long id) {
		RelacionUsuarioPeliculaDTO salida=null;
		try {
			salida = servicioRelacionUsuarioPelicula.getRelacionUsuarioPelicula(id);
			return new ResponseEntity<RelacionUsuarioPeliculaDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RelacionUsuarioPeliculaDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
