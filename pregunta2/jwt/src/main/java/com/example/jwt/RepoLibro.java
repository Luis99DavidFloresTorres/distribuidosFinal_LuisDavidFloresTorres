package com.example.jwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoLibro extends JpaRepository<Libro, Long> {
}
