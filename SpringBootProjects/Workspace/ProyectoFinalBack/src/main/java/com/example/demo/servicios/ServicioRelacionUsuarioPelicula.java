package com.example.demo.servicios;

import java.util.NoSuchElementException;

import com.example.demo.servicios.dto.relaciones.usuarioPelicula.ListadoRelacionUsuarioPeliculaDTO;
import com.example.demo.servicios.dto.relaciones.usuarioPelicula.RelacionUsuarioPeliculaDTO;

public interface ServicioRelacionUsuarioPelicula {
	public void insertarRelacionUsuarioPelicula(RelacionUsuarioPeliculaDTO entrada) throws Exception;

	public void borrarRelacionUsuarioPelicula(long id) throws Exception;

	public ListadoRelacionUsuarioPeliculaDTO getRelacionesUsuarioPelicula() throws Exception;

	public void modificarRelacionUsuarioPelicula(RelacionUsuarioPeliculaDTO entrada)
			throws NoSuchElementException, Exception;

	public RelacionUsuarioPeliculaDTO getRelacionUsuarioPelicula(long id) throws Exception;
}
