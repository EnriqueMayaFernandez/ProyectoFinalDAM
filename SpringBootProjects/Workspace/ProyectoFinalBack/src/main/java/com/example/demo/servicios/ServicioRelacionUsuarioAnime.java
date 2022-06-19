package com.example.demo.servicios;

import java.util.NoSuchElementException;

import com.example.demo.servicios.dto.relaciones.usuarioAnime.ListadoRelacionUsuarioAnimeDTO;
import com.example.demo.servicios.dto.relaciones.usuarioAnime.RelacionUsuarioAnimeDTO;


public interface ServicioRelacionUsuarioAnime {

	public void insertarRelacionUsuarioAnime(RelacionUsuarioAnimeDTO entrada) throws Exception;

	public void borrarRelacionUsuarioAnime(long id) throws Exception;

	public ListadoRelacionUsuarioAnimeDTO getRelacionesUsuarioAnime() throws Exception;

	public void modificarRelacionUsuarioAnime(RelacionUsuarioAnimeDTO entrada) throws NoSuchElementException, Exception;

	public RelacionUsuarioAnimeDTO getRelacionUsuarioAnime(long id) throws Exception;
	//public BooleanDTO comprobarAgregado(MensajeDTO nombreAnime);
}
