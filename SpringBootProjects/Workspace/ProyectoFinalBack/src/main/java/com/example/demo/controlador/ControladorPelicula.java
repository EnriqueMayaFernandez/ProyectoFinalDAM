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

import com.example.demo.servicios.ServicioPelicula;
import com.example.demo.servicios.dto.MensajeDTO;
import com.example.demo.servicios.dto.pelicula.ListadoPeliculasDTO;
import com.example.demo.servicios.dto.pelicula.PeliculaDTO;
import com.example.demo.utilidades.excepciones.EntidadExiste;

@RestController
@RequestMapping("/pelicula")
public class ControladorPelicula {

	@Autowired
	ServicioPelicula servicioPelicula;

	@PostMapping("/insertar")
	public ResponseEntity<MensajeDTO> insertarPelicula(@RequestBody PeliculaDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La pelicula se ha insertado en la base de datos con exito");
		try {
			servicioPelicula.insertarPelicula(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		}catch(EntidadExiste e) {
			salida.setMensaje("Error al insertar la pelicula en la base de datos ya que el nombre de la pelicula ya existe");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora insertar la pelicula en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modificar")
	public ResponseEntity<MensajeDTO> modificarPelicula(@RequestBody PeliculaDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La pelicula se ha modificado con exito");
		try {
			servicioPelicula.modificarPelicula(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("No se encuentra la pelicula que se quiere modificar en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de modificar la pelicula en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<MensajeDTO> borrarPelicula(@PathVariable int id) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La pelicula se ha borrado corretamente");
		try {
			servicioPelicula.borrarPelicula(id);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("La pelicula que se quiere borrar no se encuentra en la base de datos");
			return new ResponseEntity<MensajeDTO>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de borrar la pelicula");
			return new ResponseEntity<MensajeDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-peliculas")
	public ResponseEntity<ListadoPeliculasDTO> getPeliculas() {
		ListadoPeliculasDTO salida=new ListadoPeliculasDTO();
		try {
			salida=servicioPelicula.getPeliculas();
			salida.setMensaje("Se han recuperado las peliculas correctamente");
			return new ResponseEntity<ListadoPeliculasDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inesperado en la recuperacion de las peliculas");
			return new ResponseEntity<ListadoPeliculasDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-pelicula/{id}")
	public ResponseEntity<PeliculaDTO> getAnime(@PathVariable long id) {
		PeliculaDTO salida=null;
		try {
			salida = servicioPelicula.getPelicula(id);
			return new ResponseEntity<PeliculaDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<PeliculaDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
