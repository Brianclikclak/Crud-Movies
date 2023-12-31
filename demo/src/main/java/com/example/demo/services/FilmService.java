package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Film;

public interface FilmService {

    public List<Film> findAll();

    public Optional<Film> findById(Long id);

    public Film save(Film film);

    public Film updateFilmById(Long id, Film filmDetails);

    public void deleteById(Long id);

}
