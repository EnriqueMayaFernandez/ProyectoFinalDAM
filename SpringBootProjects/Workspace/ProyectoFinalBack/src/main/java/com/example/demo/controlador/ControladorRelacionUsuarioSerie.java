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

import com.example.demo.servicios.ServicioRelacionUsuarioSerie;
import com.example.demo.servicios.dto.MensajeDTO;
import com.example.demo.servicios.dto.relaciones.usuarioSerie.ListadoRelacionUsuarioSerieDTO;
import com.example.demo.servicios.dto.relaciones.usuarioSerie.RelacionUsuarioSerieDTO;

@RestController
@RequestMapping("/relacion-usuario-serie")
public class ControladorRelacionUsuarioSerie {

	@Autowired
	ServicioRelacionUsuarioSerie servicioRelacionUsuarioSerie;
	
	@PostMapping("/insertar")
	public ResponseEntity<MensajeDTO> insertarRelacionUsuarioSerie(@RequestBody RelacionUsuarioSerieDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("Se ha insertado la serie a su lista");
		try {
			servicioRelacionUsuarioSerie.insertarRelacionUsuarioSerie(entrada);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora insertar la serie en su lista");
			e.printStackTrace();
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<MensajeDTO> modificarRelacionUsuarioSerie(@RequestBody RelacionUsuarioSerieDTO entrada) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La relacion se ha modificado con exito");
		try {
			servicioRelacionUsuarioSerie.modificarRelacionUsuarioSerie(entrada);
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
	public ResponseEntity<MensajeDTO> borrarRelacionUsuarioSerie(@PathVariable long id) {
		MensajeDTO salida=new MensajeDTO();
		salida.setMensaje("La serie se ha borrado correctamente de su lista");
		try {
			servicioRelacionUsuarioSerie.borrarRelacionUsuarioSerie(id);
			return new ResponseEntity<MensajeDTO>(salida, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			salida.setMensaje("La serie que se quiere borrar no se encuentra en la base de datos");
			return new ResponseEntity<MensajeDTO>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inseperado a la hora de borrar el anime");
			return new ResponseEntity<MensajeDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-relaciones-usuario-serie")
	public ResponseEntity<ListadoRelacionUsuarioSerieDTO> getRelacionesUsuarioSerie() {
		ListadoRelacionUsuarioSerieDTO salida=null;
		try {
			salida = servicioRelacionUsuarioSerie.getRelacionesUsuarioSerie();
			salida.setMensaje("Se han recuperado las series de su lista correctamente");
			return new ResponseEntity<ListadoRelacionUsuarioSerieDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inesperado en la recuperacion de las series de su lista");
			return new ResponseEntity<ListadoRelacionUsuarioSerieDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-relacion-usuario-serie/{id}")
	public ResponseEntity<RelacionUsuarioSerieDTO> getRelacionUsuarioSerie(@PathVariable long id) {
		RelacionUsuarioSerieDTO salida=null;
		try {
			salida = servicioRelacionUsuarioSerie.getRelacionUsuarioSerie(id);
			return new ResponseEntity<RelacionUsuarioSerieDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RelacionUsuarioSerieDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
