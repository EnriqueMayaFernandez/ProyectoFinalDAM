package com.example.demo.servicios.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Anime;
import com.example.demo.modelo.Genero;
import com.example.demo.servicios.ServicioAnime;
import com.example.demo.servicios.dao.AnimeDAO;
import com.example.demo.servicios.dto.anime.AnimeDTO;
import com.example.demo.servicios.dto.anime.ListadoAnimesDTO;
import com.example.demo.servicios.dto.genero.GeneroDTO;
import com.example.demo.utilidades.excepciones.EntidadExiste;
import com.example.demo.utilidades.utils.Utilidades;

@Service
@Transactional
public class ServicioAnimeImpl implements ServicioAnime {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	AnimeDAO animeDAO;

	@Override
	public void insertarAnime(AnimeDTO entrada) throws Exception {
		List<Anime> animeExiste = animeDAO.findByNombreAnime(entrada.getNombreAnime());
		if (animeExiste.size() == 0) {
			Genero genero = new Genero(entrada.getGenero().getId(), entrada.getGenero().getNombreGenero());
			Date fechaEmision=Utilidades.ParseFecha(entrada.getFechaEmision(),"yyyy-MM-dd");
			Date fechaFinalizacion=Utilidades.ParseFecha(entrada.getFechaFinalizacion(),"yyyy-MM-dd");
			Anime anime = new Anime(entrada.getNombreAnime(), entrada.getEstudioAnimacion(), fechaEmision,
					fechaFinalizacion, entrada.getNumeroCapitulos(), genero);
			animeDAO.save(anime);
		} else {
			throw new EntidadExiste();
		}

	}

	@Override
	public void borrarAnime(long id) throws Exception {
		animeDAO.deleteById(id);

	}

	@Override
	public ListadoAnimesDTO getAnimes() throws Exception {
		ListadoAnimesDTO listaAnimes = new ListadoAnimesDTO();
		List<Anime> lista = animeDAO.findAllByOrderByNombreAnimeAsc();
		for (Anime anime : lista) {
			String fechaEmisionFormateada = Utilidades.formatearFecha(anime.getFechaEmision(),"dd/MM/yyyy");
			String fechaFinalizacionFormateada = Utilidades.formatearFecha(anime.getFechaFinalizacion(),"dd/MM/yyyy");
			GeneroDTO generoDTO = new GeneroDTO(anime.getGenero().getId(), anime.getGenero().getNombreGenero());
			AnimeDTO animeDTO = new AnimeDTO(anime.getId(), anime.getNombreAnime(), anime.getEstudioAnimacion(),
					fechaEmisionFormateada, fechaFinalizacionFormateada, anime.getNumeroCapitulos(), generoDTO);
			listaAnimes.getListaAnimes().add(animeDTO);
		}
		return listaAnimes;
	}

	@Override
	public void modificarAnime(AnimeDTO entrada) throws NoSuchElementException, Exception {
		Anime existeAnime = animeDAO.getOne(entrada.getId());
		Genero genero = new Genero(entrada.getGenero().getId(), entrada.getGenero().getNombreGenero());
		Date fechaEmision=Utilidades.ParseFecha(entrada.getFechaEmision(),"yyyy-MM-dd");
		Date fechaFinalizacion=Utilidades.ParseFecha(entrada.getFechaFinalizacion(),"yyyy-MM-dd");
		Anime anime = new Anime(entrada.getId(), entrada.getNombreAnime(), entrada.getEstudioAnimacion(),
				fechaEmision, fechaFinalizacion, entrada.getNumeroCapitulos(), genero);
		animeDAO.save(anime);
	}

	@Override
	public AnimeDTO getAnime(long id) throws Exception {
		Anime anime = animeDAO.getOne(id);
		GeneroDTO generoDTO=new GeneroDTO(anime.getGenero().getId(),anime.getGenero().getNombreGenero());
		String fechaEmisionFormateada = Utilidades.formatearFecha(anime.getFechaEmision(),"yyyy-MM-dd");
		String fechaFinalizacionFormateada = Utilidades.formatearFecha(anime.getFechaFinalizacion(),"yyyy-MM-dd");
		AnimeDTO animeDTO=new AnimeDTO(anime.getId(),anime.getNombreAnime(),anime.getEstudioAnimacion(),fechaEmisionFormateada ,fechaFinalizacionFormateada,anime.getNumeroCapitulos(),generoDTO);
		return animeDTO;
	}

}
