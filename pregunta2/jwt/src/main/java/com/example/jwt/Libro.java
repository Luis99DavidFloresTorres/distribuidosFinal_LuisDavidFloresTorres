package com.example.jwt;

import javax.ejb.Local;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity(name="libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Date aniopublicacion;
    private String univco;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getAniopublicacion() {
        return aniopublicacion;
    }

    public void setAniopublicacion(Date aniopublicacion) {
        this.aniopublicacion = aniopublicacion;
    }

    public String getUnivco() {
        return univco;
    }

    public void setUnivco(String univco) {
        this.univco = univco;
    }
}
