package com.example.demo.servicios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.RelacionUsuarioPelicula;

public interface RelacionUsuarioPeliculaDAO extends JpaRepository<RelacionUsuarioPelicula, Long>{
}
