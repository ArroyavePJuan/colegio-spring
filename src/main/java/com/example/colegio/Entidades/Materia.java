package com.example.colegio.Entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @Column(name = "id_materia", nullable = false )
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "creditos", nullable = false)
    private Integer creditos;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    public Materia() {
    }

    public Materia(Integer id, String nombre, Integer creditos, Profesor profesor) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.profesor = profesor;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
