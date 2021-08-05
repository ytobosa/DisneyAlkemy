package com.alfonso.alkemy.service;

import java.util.*;
import java.util.stream.Collectors;

import com.alfonso.alkemy.DTO.EntPeliculaDto;
import com.alfonso.alkemy.DTO.EntPersonajeDto;
import com.alfonso.alkemy.DTO.PeliculaDto;
import com.alfonso.alkemy.DTO.PersonajeDto;
import com.alfonso.alkemy.entity.Personaje;
import com.alfonso.alkemy.repository.IPersonajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfonso.alkemy.entity.PeliculaSerie;
import com.alfonso.alkemy.interfaces.IPeliculaSerieService;
import com.alfonso.alkemy.repository.IPeliculaRepository;

@Service
public class PeliculaSerieService implements IPeliculaSerieService {
    @Autowired
    IPeliculaRepository peliSerieRepo;
    @Autowired
    IPersonajeRepository personajeRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PeliculaDto> findAll() {
        List<Object[]> pelis = peliSerieRepo.findListaPelis();
        List<PeliculaDto> peliculas = new ArrayList<>();
        for (Object[] objects : pelis) {
            PeliculaDto pelicula = new PeliculaDto();
            pelicula.setImagen((String) objects[0]);
            pelicula.setTitulo((String) objects[1]);
            pelicula.setFechaCreacion((Date) objects[2]);
            peliculas.add(pelicula);
        }
        return peliculas;
    }

    @Override
    public EntPeliculaDto findById(Long id) {
        PeliculaSerie pelicula = peliSerieRepo.findById(id).orElseThrow(() ->
                new NoSuchElementException("No existe un personaje con el id: " + id));
        List<EntPersonajeDto> personajesDto = pelicula.getPersonajes().stream()
                .map(this::modelToDTOPersonaje).collect(Collectors.toList());
        EntPeliculaDto peliculaDto = modelToDTOPelicula(pelicula);
        peliculaDto.setPersonajes(personajesDto);
        return peliculaDto;
    }


    @Override
    public EntPeliculaDto save(PeliculaSerie peliSerie) {
        PeliculaSerie pelicula = peliSerieRepo.save(peliSerie);
        return modelToDTOPelicula(pelicula) ;
    }

    @Override
    public PeliculaSerie update(PeliculaSerie PeliSerie) {
        return peliSerieRepo.save(PeliSerie);
    }

    @Override
    public void deleteById(Long id) {
        peliSerieRepo.deleteById(id);
    }

    @Override
    public List<PeliculaSerie> findBytitulo(String nombre) {

        return null;
    }

    @Override
    public List<PeliculaSerie> findByGenero(int genero) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PeliculaSerie> findAllAsc(int genero) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PeliculaSerie> findAllDesc(int genero) {
        // TODO Auto-generated method stub
        return null;
    }

    private EntPeliculaDto modelToDTOPelicula(PeliculaSerie pelicula) {
        return modelMapper.map(pelicula, EntPeliculaDto.class);
    }

    private EntPersonajeDto modelToDTOPersonaje(Personaje personaje) {
        return modelMapper.map(personaje, EntPersonajeDto.class);
    }
}
