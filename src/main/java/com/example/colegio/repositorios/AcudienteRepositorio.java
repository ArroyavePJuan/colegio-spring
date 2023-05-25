package com.example.colegio.repositorios;

import com.example.colegio.Entidades.Acudiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcudienteRepositorio extends JpaRepository<Acudiente, Integer> {

}
