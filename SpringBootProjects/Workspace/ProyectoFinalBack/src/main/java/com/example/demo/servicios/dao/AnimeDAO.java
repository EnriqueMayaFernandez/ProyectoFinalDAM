package com.example.demo.servicios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Anime;

public interface AnimeDAO extends JpaRepository<Anime, Long>{
	List<Anime>  findByNombreAnime(String nombreAnime);
	List<Anime> findAllByOrderByNombreAnimeAsc();
}
