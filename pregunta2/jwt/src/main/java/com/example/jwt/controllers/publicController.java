package com.example.jwt.controllers;
import com.example.jwt.Libro;
import com.example.jwt.RepoLibro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/public")
public class publicController {
    private final RepoLibro repoLibro;
    public publicController(RepoLibro repoLibro){
        this.repoLibro = repoLibro;
    }
    @GetMapping("/obtener")
    public ResponseEntity<List<Libro>> obtenerTareas(){
        List<Libro> obtenerLibros = this.repoLibro.findAll();
        return new ResponseEntity<>(obtenerLibros, HttpStatus.OK);
    }
}
