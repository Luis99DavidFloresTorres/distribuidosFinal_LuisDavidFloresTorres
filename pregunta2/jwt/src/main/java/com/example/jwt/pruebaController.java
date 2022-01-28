package com.example.jwt;

import com.example.jwt.security.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class pruebaController {
    UsuarioRepository usuarioRepository;
    public pruebaController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @GetMapping("/prueba")
    public ResponseEntity<List<Usuario>> todos(){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }
}