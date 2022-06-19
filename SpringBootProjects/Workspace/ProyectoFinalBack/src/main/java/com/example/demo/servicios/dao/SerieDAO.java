package com.example.demo.servicios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Serie;


public interface SerieDAO extends JpaRepository<Serie, Long>{
	List<Serie>  findByNombreSerie(String nombreSerie);
	List<Serie> findAllByOrderByNombreSerieAsc();
}
