package com.example.jwt.security;


import com.example.jwt.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsuario(String usuario);

}
