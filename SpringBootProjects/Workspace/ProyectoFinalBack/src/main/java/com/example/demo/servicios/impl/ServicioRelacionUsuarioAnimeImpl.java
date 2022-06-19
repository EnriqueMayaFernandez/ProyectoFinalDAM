package com.example.demo.servicios.impl;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Anime;
import com.example.demo.modelo.RelacionUsuarioAnime;
import com.example.demo.modelo.Usuario;
import com.example.demo.servicios.ServicioRelacionUsuarioAnime;
import com.example.demo.servicios.dao.RelacionUsuarioAnimeDAO;
import com.example.demo.servicios.dto.relaciones.usuarioAnime.ListadoRelacionUsuarioAnimeDTO;
import com.example.demo.servicios.dto.relaciones.usuarioAnime.RelacionUsuarioAnimeDTO;

@Service
@Transactional
public class ServicioRelacionUsuarioAnimeImpl implements ServicioRelacionUsuarioAnime {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	RelacionUsuarioAnimeDAO relacionUsuarioAnimeDAO;

	@Override
	public void insertarRelacionUsuarioAnime(RelacionUsuarioAnimeDTO entrada) throws Exception {
		Anime anime = new Anime();
		anime.setId(entrada.getIdAnime());
		Usuario usuario = new Usuario();
		usuario.setId(entrada.getIdUsuario());
		RelacionUsuarioAnime relacionUsuarioAnime = new RelacionUsuarioAnime(entrada.getId(),anime, usuario,
				entrada.getPuntuacion(), entrada.getEstado(),entrada.getNotas());
		relacionUsuarioAnimeDAO.save(relacionUsuarioAnime);
	}

	@Override
	public void borrarRelacionUsuarioAnime(long id) throws Exception {
		relacionUsuarioAnimeDAO.deleteById(id);

	}

	@Override
	public ListadoRelacionUsuarioAnimeDTO getRelacionesUsuarioAnime() throws Exception {
		ListadoRelacionUsuarioAnimeDTO listaRelacionUsuarioAnime = new ListadoRelacionUsuarioAnimeDTO();
		List<RelacionUsuarioAnime> lista = relacionUsuarioAnimeDAO.findAll();;
		for (RelacionUsuarioAnime relacionUsuarioAnime : lista) {
			RelacionUsuarioAnimeDTO relacionUsuarioAnimeDTO = new RelacionUsuarioAnimeDTO(
					relacionUsuarioAnime.getId(), relacionUsuarioAnime.getAnime().getId(),
					relacionUsuarioAnime.getUsuario().getId(), relacionUsuarioAnime.getPuntuacion(),
					relacionUsuarioAnime.getEstado(),relacionUsuarioAnime.getAnime().getNombreAnime(),relacionUsuarioAnime.getNotas());
			listaRelacionUsuarioAnime.getListadoRelacionUsuarioAnime().add(relacionUsuarioAnimeDTO);
		}
		return listaRelacionUsuarioAnime;
	}

	@Override
	public void modificarRelacionUsuarioAnime(RelacionUsuarioAnimeDTO entrada)
			throws NoSuchElementException, Exception {
		Anime anime = new Anime();
		anime.setId(entrada.getIdAnime());
		Usuario usuario = new Usuario();
		usuario.setId(entrada.getIdUsuario());
		RelacionUsuarioAnime relacionUsuarioAnime = new RelacionUsuarioAnime(entrada.getId(), anime, usuario,
				entrada.getPuntuacion(), entrada.getEstado(),entrada.getNotas());
		relacionUsuarioAnimeDAO.save(relacionUsuarioAnime);
	}

	@Override
	public RelacionUsuarioAnimeDTO getRelacionUsuarioAnime(long id) throws Exception {
		RelacionUsuarioAnime relacionUsuarioAnime = relacionUsuarioAnimeDAO.getOne(id);
		RelacionUsuarioAnimeDTO relacionUsuarioAnimeDTO=new RelacionUsuarioAnimeDTO(relacionUsuarioAnime.getId(), relacionUsuarioAnime.getAnime().getId(),
				relacionUsuarioAnime.getUsuario().getId(), relacionUsuarioAnime.getPuntuacion(),
				relacionUsuarioAnime.getEstado(),relacionUsuarioAnime.getAnime().getNombreAnime(),relacionUsuarioAnime.getNotas());
		return relacionUsuarioAnimeDTO;
	}

	/*@Override
	public BooleanDTO comprobarAgregado(MensajeDTO nombreAnime) {
		List<Anime> animeExiste = relacionUsuarioAnimeDAO.findByNombreAnime(nombreAnime.getMensaje());
		BooleanDTO estaEnLaLista= new BooleanDTO();
		estaEnLaLista.setAgregado(false);
		if(animeExiste.size()==0) {
			estaEnLaLista.setAgregado(true);
		}
		return estaEnLaLista;
	}*/
	
	
}
