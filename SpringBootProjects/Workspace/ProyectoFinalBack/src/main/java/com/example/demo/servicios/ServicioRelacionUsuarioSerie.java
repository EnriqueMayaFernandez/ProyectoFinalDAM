package com.example.demo.servicios;

import java.util.NoSuchElementException;

import com.example.demo.servicios.dto.relaciones.usuarioSerie.ListadoRelacionUsuarioSerieDTO;
import com.example.demo.servicios.dto.relaciones.usuarioSerie.RelacionUsuarioSerieDTO;


public interface ServicioRelacionUsuarioSerie {
	public void insertarRelacionUsuarioSerie(RelacionUsuarioSerieDTO entrada) throws Exception;

	public void borrarRelacionUsuarioSerie(long id) throws Exception;

	public ListadoRelacionUsuarioSerieDTO getRelacionesUsuarioSerie() throws Exception;

	public void modificarRelacionUsuarioSerie(RelacionUsuarioSerieDTO entrada)
			throws NoSuchElementException, Exception;

	public RelacionUsuarioSerieDTO getRelacionUsuarioSerie(long id) throws Exception;
}
