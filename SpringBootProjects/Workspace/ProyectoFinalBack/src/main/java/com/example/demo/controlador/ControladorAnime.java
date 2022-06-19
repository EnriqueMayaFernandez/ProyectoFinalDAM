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

import com.example.demo.servicios.ServicioAnime;
import com.example.demo.servicios.dto.MensajeDTO;
import com.example.demo.servicios.dto.anime.AnimeDTO;
import com.example.demo.servicios.dto.anime.ListadoAnimesDTO;
import com.example.demo.utilidades.excepciones.EntidadExiste;

@RestController
@RequestMapping("/anime")
public class ControladorAnime {
	@Autowired
	ServicioAnime servicioAnime;
	
	@PostMapping("/insertar")
	public ResponseEntity<MensajeDTO> insertarAnime(@RequestBody AnimeDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("El anime se ha insertado en la base de datos con exito");
		try {
			servicioAnime.insertarAnime(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		}catch(EntidadExiste e) {
			salida.setMensaje("Error al insertar el anime en la base de datos ya que el nombre de la serie ya existe");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora insertar el anime en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<MensajeDTO> modificarAnime(@RequestBody AnimeDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("El anime se ha modificado con exito");
		try {
			servicioAnime.modificarAnime(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("No se encuentra el anime que se quiere modificar en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de modificar el anime en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<MensajeDTO> borrarAnime(@PathVariable long id) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("El anime se ha borrado correctamente");
		try {
			servicioAnime.borrarAnime(id);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("El anime que se quiere borrar no se encuentra en la base de datos");
			return new ResponseEntity<MensajeDTO>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de borrar el anime");
			return new ResponseEntity<MensajeDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-animes")
	public ResponseEntity<ListadoAnimesDTO> getAnimes() {
		ListadoAnimesDTO salida=null;
		try {
			salida = servicioAnime.getAnimes();
			salida.setMensaje("Se han recuperado los animes correctamente");
			return new ResponseEntity<ListadoAnimesDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inesperado en la recuperacion de los animes");
			return new ResponseEntity<ListadoAnimesDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-anime/{id}")
	public ResponseEntity<AnimeDTO> getAnime(@PathVariable long id) {
		AnimeDTO salida=null;
		try {
			salida = servicioAnime.getAnime(id);
			return new ResponseEntity<AnimeDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AnimeDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
