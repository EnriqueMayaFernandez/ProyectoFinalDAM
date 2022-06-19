package com.example.demo.servicios.impl;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.RelacionUsuarioSerie;
import com.example.demo.modelo.Serie;
import com.example.demo.modelo.Usuario;
import com.example.demo.servicios.dao.RelacionUsuarioSerieDAO;
import com.example.demo.servicios.dto.relaciones.usuarioSerie.ListadoRelacionUsuarioSerieDTO;
import com.example.demo.servicios.dto.relaciones.usuarioSerie.RelacionUsuarioSerieDTO;

@Service
@Transactional
public class ServicioRelacionUsuarioSerieImpl implements com.example.demo.servicios.ServicioRelacionUsuarioSerie{

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	RelacionUsuarioSerieDAO relacionUsuarioSerieDAO;
	
	@Override
	public void insertarRelacionUsuarioSerie(RelacionUsuarioSerieDTO entrada) throws Exception {
		Serie serie = new Serie();
		serie.setId(entrada.getIdSerie());
		Usuario usuario = new Usuario();
		usuario.setId(entrada.getIdUsuario());
		RelacionUsuarioSerie relacionUsuarioSerie = new RelacionUsuarioSerie(entrada.getId(),serie, usuario,
				entrada.getPuntuacion(), entrada.getEstado(),entrada.getNotas());
		relacionUsuarioSerieDAO.save(relacionUsuarioSerie);
	}

	@Override
	public void borrarRelacionUsuarioSerie(long id) throws Exception {
		relacionUsuarioSerieDAO.deleteById(id);
	}

	@Override
	public ListadoRelacionUsuarioSerieDTO getRelacionesUsuarioSerie() throws Exception {
		ListadoRelacionUsuarioSerieDTO listaRelacionUsuarioSerie = new ListadoRelacionUsuarioSerieDTO();
		List<RelacionUsuarioSerie> lista = relacionUsuarioSerieDAO.findAll();
		for (RelacionUsuarioSerie relacionUsuarioSerie : lista) {
			RelacionUsuarioSerieDTO relacionUsuarioSerieDTO = new RelacionUsuarioSerieDTO(
					relacionUsuarioSerie.getId(), relacionUsuarioSerie.getSerie().getId(),
					relacionUsuarioSerie.getUsuario().getId(), relacionUsuarioSerie.getPuntuacion(),
					relacionUsuarioSerie.getEstado(),relacionUsuarioSerie.getSerie().getNombreSerie(),relacionUsuarioSerie.getNotas());
			listaRelacionUsuarioSerie.getListadoRelacionUsuarioSerie().add(relacionUsuarioSerieDTO);
		}
		return listaRelacionUsuarioSerie;
	}

	@Override
	public void modificarRelacionUsuarioSerie(RelacionUsuarioSerieDTO entrada)
			throws NoSuchElementException, Exception {
		Serie serie = new Serie();
		serie.setId(entrada.getIdSerie());
		Usuario usuario = new Usuario();
		usuario.setId(entrada.getIdUsuario());
		RelacionUsuarioSerie relacionUsuarioSerie = new RelacionUsuarioSerie(entrada.getId(), serie, usuario,
				entrada.getPuntuacion(), entrada.getEstado(),entrada.getNotas());
		relacionUsuarioSerieDAO.save(relacionUsuarioSerie);
	}

	@Override
	public RelacionUsuarioSerieDTO getRelacionUsuarioSerie(long id) throws Exception {
		RelacionUsuarioSerie relacionUsuarioAnime = relacionUsuarioSerieDAO.getOne(id);
		RelacionUsuarioSerieDTO relacionUsuarioAnimeDTO=new RelacionUsuarioSerieDTO(relacionUsuarioAnime.getId(), relacionUsuarioAnime.getSerie().getId(),
				relacionUsuarioAnime.getUsuario().getId(), relacionUsuarioAnime.getPuntuacion(),
				relacionUsuarioAnime.getEstado(),relacionUsuarioAnime.getSerie().getNombreSerie(),relacionUsuarioAnime.getNotas());
		return relacionUsuarioAnimeDTO;
	}

}
