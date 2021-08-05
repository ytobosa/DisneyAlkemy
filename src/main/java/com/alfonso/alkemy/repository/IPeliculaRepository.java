package com.alfonso.alkemy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alfonso.alkemy.entity.PeliculaSerie;


public interface IPeliculaRepository extends JpaRepository<PeliculaSerie, Long>{

    @Query(value="select pel.imagen, pel.titulo, pel.fechaCreacion from PeliculaSerie pel")
    public List<Object[]> findListaPelis();


}
