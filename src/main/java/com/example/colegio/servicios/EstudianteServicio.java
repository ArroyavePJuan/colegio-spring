package com.example.colegio.servicios;

import com.example.colegio.Entidades.Acudiente;
import com.example.colegio.Entidades.Estudiante;
import com.example.colegio.repositorios.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;


public class EstudianteServicio implements ServicioBase<Estudiante> {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiante> buscarTodos() throws Exception {
        try{
            List<Estudiante>estudiantes=estudianteRepositorio.findAll();
            return estudiantes;

        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Estudiante buscarPorId(Integer id) throws Exception {
        try{
            Optional<Estudiante> estudianteOpcional =estudianteRepositorio.findById(id);
            if(estudianteOpcional.isPresent()){
                return estudianteOpcional.get();
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Estudiante registrar(Estudiante datosARegistrar) throws Exception {
        return null;
    }

    @Override
    public Estudiante actualizar(Integer id, Estudiante datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
