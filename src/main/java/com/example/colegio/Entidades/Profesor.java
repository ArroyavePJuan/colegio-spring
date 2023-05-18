package com.example.colegio.Entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "nombre", nullable = false)
    private Integer escalafon;

    public Profesor() {
    }

    public Profesor(Integer id, String nombre, Integer escalafon) {
        this.id = id;
        this.nombre = nombre;
        this.escalafon = escalafon;
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

    public Integer getEscalafon() {
        return escalafon;
    }

    public void setEscalafon(Integer escalafon) {
        this.escalafon = escalafon;
    }
}
