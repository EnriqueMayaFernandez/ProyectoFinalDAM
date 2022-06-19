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

import com.example.demo.servicios.ServicioSerie;
import com.example.demo.servicios.dto.MensajeDTO;
import com.example.demo.servicios.dto.serie.ListadoSeriesDTO;
import com.example.demo.servicios.dto.serie.SerieDTO;
import com.example.demo.utilidades.excepciones.EntidadExiste;

@RestController
@RequestMapping("/serie")
public class ControladorSerie {
 
	@Autowired
	ServicioSerie servicioSerie;
	
	@PostMapping("/insertar")
	public ResponseEntity<MensajeDTO> insertarSerie(@RequestBody SerieDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La serie se ha insertado en la base de datos con exito");
		try {
			servicioSerie.insertarSerie(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		}catch(EntidadExiste e) {
			salida.setMensaje("Error al insertar la serie en la base de datos ya que el nombre de la serie ya existe");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora insertar la serie en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modificar")
	public ResponseEntity<MensajeDTO> modificarSerie(@RequestBody SerieDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La serie se ha modificado con exito");
		try {
			servicioSerie.modificarSerie(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("No se encuentra la serie que se quiere modificar en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de modificar la serie en la base de datos");
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<MensajeDTO> borrarSerie(@PathVariable int id) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La serie se ha borrado correctamente");
		try {
			servicioSerie.borrarSerie(id);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("La serie que se quiere borrar no se encuentra en la base de datos");
			return new ResponseEntity<MensajeDTO>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de borrar la serie");
			return new ResponseEntity<MensajeDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-series")
	public ResponseEntity<ListadoSeriesDTO> getSeries() {
		ListadoSeriesDTO salida=null;
		try {
			salida = servicioSerie.getSeries();
			salida.setMensaje("Se han recuperado las series correctamente");
			return new ResponseEntity<ListadoSeriesDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inesperado en la recuperacion de las series");
			return new ResponseEntity<ListadoSeriesDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-serie/{id}")
	public ResponseEntity<SerieDTO> getAnime(@PathVariable long id) {
		SerieDTO salida=null;
		try {
			salida = servicioSerie.getSerie(id);
			return new ResponseEntity<SerieDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SerieDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
