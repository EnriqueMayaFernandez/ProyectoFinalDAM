package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.servicios.ServicioPelicula;
import com.example.demo.servicios.dto.SalidaListadoDTO;
import com.example.demo.servicios.dto.pelicula.EntradaPeliculaDTO;


@RestController
@RequestMapping("/pelicula")
public class ControladorPelicula {

	@Autowired
	ServicioPelicula peliculaService;
	
	@PostMapping("/insertar")
	public ResponseEntity<String> insertarPelicula(@RequestBody EntradaPeliculaDTO entrada) {
		String salida;
			salida = peliculaService.insertarPelicula(entrada);
			return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/borrar/{id}")
	public ResponseEntity<String> getCliente(@PathVariable int id){
		 String salida;
		 salida = peliculaService.borrarPelicula(id);
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/get-peliculas")
	public ResponseEntity<SalidaListadoDTO> getPeliculas() {
		SalidaListadoDTO salida;
			salida=peliculaService.getPeliculas();
			return ResponseEntity.ok(salida);
	}
}
