package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Film;
import com.example.demo.services.FilmService;

@RestController
@RequestMapping

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id) {
        return filmService.findById(id);
    }

}