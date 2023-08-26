package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Film;
import com.example.demo.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmrepository;

    @Override
    @Transactional(readOnly = true)
    public List<Film> findAll() {
        return filmrepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Film> findById(Long id) {
        return filmrepository.findById(id);
    }

}
