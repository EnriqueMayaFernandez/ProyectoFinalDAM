package com.example.demo.servicios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Genero;

public interface GeneroDAO extends JpaRepository<Genero, Long>{
	List<Genero> findAllByOrderByNombreGeneroAsc();
}
