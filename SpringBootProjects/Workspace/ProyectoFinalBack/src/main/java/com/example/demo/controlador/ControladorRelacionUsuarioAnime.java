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

import com.example.demo.servicios.ServicioRelacionUsuarioAnime;
import com.example.demo.servicios.dto.MensajeDTO;
import com.example.demo.servicios.dto.relaciones.usuarioAnime.ListadoRelacionUsuarioAnimeDTO;
import com.example.demo.servicios.dto.relaciones.usuarioAnime.RelacionUsuarioAnimeDTO;

@RestController
@RequestMapping("/relacion-usuario-anime")
public class ControladorRelacionUsuarioAnime {
	@Autowired
	ServicioRelacionUsuarioAnime servicioRelacionUsuarioAnime;
	
	@PostMapping("/insertar")
	public ResponseEntity<MensajeDTO> insertarAnime(@RequestBody RelacionUsuarioAnimeDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("Se ha insertado el anime a su lista");
		try {
			servicioRelacionUsuarioAnime.insertarRelacionUsuarioAnime(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora insertar el anime en su lista");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<MensajeDTO> modificarAnime(@RequestBody RelacionUsuarioAnimeDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La relacion se ha modificado con exito");
		try {
			servicioRelacionUsuarioAnime.modificarRelacionUsuarioAnime(entrada);
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
	public ResponseEntity<MensajeDTO> borrarAnime(@PathVariable long id) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("El anime se ha borrado correctamente");
		try {
			servicioRelacionUsuarioAnime.borrarRelacionUsuarioAnime(id);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("El anime que se quiere borrar no se encuentra en la base de datos");
			return new ResponseEntity<MensajeDTO>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de borrar el anime");
			return new ResponseEntity<MensajeDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-relaciones-usuario-anime")
	public ResponseEntity<ListadoRelacionUsuarioAnimeDTO> getAnimes() {
		ListadoRelacionUsuarioAnimeDTO salida=null;
		try {
			salida = servicioRelacionUsuarioAnime.getRelacionesUsuarioAnime();
			salida.setMensaje("Se han recuperado los animes de su lista correctamente");
			return new ResponseEntity<ListadoRelacionUsuarioAnimeDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inesperado en la recuperacion de los animes de su lista");
			return new ResponseEntity<ListadoRelacionUsuarioAnimeDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-relacion-usuario-anime/{id}")
	public ResponseEntity<RelacionUsuarioAnimeDTO> getAnime(@PathVariable long id) {
		RelacionUsuarioAnimeDTO salida=null;
		try {
			salida = servicioRelacionUsuarioAnime.getRelacionUsuarioAnime(id);
			return new ResponseEntity<RelacionUsuarioAnimeDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RelacionUsuarioAnimeDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
