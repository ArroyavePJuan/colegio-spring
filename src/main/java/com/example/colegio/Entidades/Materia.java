package com.example.colegio.Entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

    private Integer id;

    private String nombre;

    private Integer creditos;

    public Materia() {
    }

    public Materia(Integer id, String nombre, Integer creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}
