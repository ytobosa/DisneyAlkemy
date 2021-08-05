package com.alfonso.alkemy.interfaces;

import java.util.List;
import java.util.Optional;

import com.alfonso.alkemy.DTO.EntPeliculaDto;
import com.alfonso.alkemy.DTO.PeliculaDto;
import com.alfonso.alkemy.entity.PeliculaSerie;


public interface IPeliculaSerieService {
	
	public List<PeliculaDto> findAll();
	public EntPeliculaDto findById(Long id);
	public EntPeliculaDto save(PeliculaSerie PeliSerie);
	public PeliculaSerie update(PeliculaSerie PeliSerie);
	public void deleteById(Long id);
	public List<PeliculaSerie> findBytitulo(String nombre);
	public List<PeliculaSerie> findByGenero(int genero);
	public List<PeliculaSerie> findAllAsc(int genero);
	public List<PeliculaSerie> findAllDesc(int genero);
}
