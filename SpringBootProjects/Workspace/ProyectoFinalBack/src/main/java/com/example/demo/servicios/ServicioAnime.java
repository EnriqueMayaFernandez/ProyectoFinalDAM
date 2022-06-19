package com.example.demo.servicios;

import java.util.NoSuchElementException;

import com.example.demo.servicios.dto.anime.AnimeDTO;
import com.example.demo.servicios.dto.anime.ListadoAnimesDTO;

public interface ServicioAnime {
	public void insertarAnime(AnimeDTO entrada) throws Exception;
	public void borrarAnime(long id) throws Exception;
	public ListadoAnimesDTO getAnimes() throws Exception;
	public void modificarAnime(AnimeDTO entrada) throws NoSuchElementException, Exception;
	public AnimeDTO getAnime(long id) throws Exception;
}
