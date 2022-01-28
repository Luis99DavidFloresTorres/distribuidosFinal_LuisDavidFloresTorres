package com.example.jwt.controllers;

import com.example.jwt.Libro;
import com.example.jwt.RepoLibro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class privateController {
    private final RepoLibro repoLibro;
    public privateController(RepoLibro repoLibro){
        this.repoLibro = repoLibro;
    }
    @PostMapping("/agregar")
    public void agregar(@RequestBody Libro libro){
        System.out.println(libro.getAniopublicacion());

        repoLibro.save(libro);
    }
    @PostMapping("/eliminar")
    public void eliminar(@RequestBody Libro libro){

        Optional<Libro> tareas = repoLibro.findById(libro.getId());
        repoLibro.delete(tareas.get());
    }
    @PutMapping("/editar")
    public void editar(@RequestBody Libro libro){
        repoLibro.save(libro);
    }
    @PatchMapping("/patch")
    public void patch(@RequestBody Libro libro){
        Optional<Libro> libroObtener = repoLibro.findById(libro.getId());
        if(!Objects.isNull(libro.getTitulo())){
            libroObtener.get().setTitulo(libro.getTitulo());
        }
        if(!Objects.isNull(libro.getAniopublicacion())){
            libro.setAniopublicacion(libro.getAniopublicacion());
        }
        if(!Objects.isNull(libro.getAutor())){
            libro.setAutor(libro.getAutor());
        }
        repoLibro.save(libroObtener.get());
    }
}
