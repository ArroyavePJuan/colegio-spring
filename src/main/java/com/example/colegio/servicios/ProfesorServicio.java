package com.example.colegio.servicios;

import com.example.colegio.Entidades.Acudiente;
import com.example.colegio.Entidades.Materia;
import com.example.colegio.Entidades.Profesor;
import com.example.colegio.repositorios.MateriaRepositorio;
import com.example.colegio.repositorios.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProfesorServicio implements ServicioBase<Profesor> {

    @Autowired
    protected ProfesorRepositorio profesorRepositorio;

    @Override
    public List<Profesor> buscarTodos() throws Exception {
        try{
            List<Profesor>profesores=profesorRepositorio.findAll();
            return profesores;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Profesor buscarPorId(Integer id) throws Exception {
        try{
            Optional<Profesor> profesorOpcional =profesorRepositorio.findById(id);
            if(profesorOpcional.isPresent()){
                return profesorOpcional.get();
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Profesor registrar(Profesor datosARegistrar) throws Exception {
        try{
            Profesor profesorGuardado=profesorRepositorio.save(datosARegistrar);
            return profesorGuardado;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Profesor actualizar(Integer id, Profesor datosNuevos) throws Exception {
        try{
            Optional<Profesor>profesorOpcional =profesorRepositorio.findById(id);
            if(profesorOpcional.isPresent()){
                Profesor profesorActualizado=profesorRepositorio.save(datosNuevos);
                return profesorActualizado;
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{

            Optional<Profesor>profesorOpcional =profesorRepositorio.findById(id);
            if(profesorOpcional.isPresent()){
                profesorRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public static class MateriaServicio implements ServicioBase<Materia>{

        @Autowired
        protected MateriaRepositorio materiaRepositorio;

        @Override
        public List<Materia> buscarTodos() throws Exception {
            try{
                List<Materia>materias=materiaRepositorio.findAll();
                return materias;
            }catch(Exception error){
                throw new Exception(error.getMessage());
            }
        }

        @Override
        public Materia buscarPorId(Integer id) throws Exception {
            try{
                Optional<Materia> materiaOpcional =materiaRepositorio.findById(id);
                if(materiaOpcional.isPresent()){
                    return materiaOpcional.get();
                }else{
                    throw new Exception("Usuario no encontrado");
                }
            }catch(Exception error){
                throw new Exception(error.getMessage());
            }
        }

        @Override
        public Materia registrar(Materia datosARegistrar) throws Exception {
            try{
                Materia materiaGuardado=materiaRepositorio.save(datosARegistrar);
                return materiaGuardado;
            }catch(Exception error){
                throw new Exception(error.getMessage());
            }
        }

        @Override
        public Materia actualizar(Integer id, Materia datosNuevos) throws Exception {
            try{
                Optional<Materia>materiaOpcional =materiaRepositorio.findById(id);
                if(materiaOpcional.isPresent()){
                    Materia materiaActualizado=materiaRepositorio.save(datosNuevos);
                    return materiaActualizado;
                }else{
                    throw new Exception("Usuario no encontrado");
                }
            }catch(Exception error){
                throw new Exception(error.getMessage());
            }
        }

        @Override
        public boolean eliminar(Integer id) throws Exception {
            try{

                Optional<Materia>materiaOpcional =materiaRepositorio.findById(id);
                if(materiaOpcional.isPresent()){
                    materiaRepositorio.deleteById(id);
                    return true;
                }else{
                    throw new Exception("Usuario no encontrado");
                }

            }catch(Exception error){
                throw new Exception(error.getMessage());
            }
        }
    }
}
