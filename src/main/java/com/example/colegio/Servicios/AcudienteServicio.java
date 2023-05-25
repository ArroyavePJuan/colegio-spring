package com.example.colegio.Servicios;

import com.example.colegio.Entidades.Acudiente;
import com.example.colegio.repositorios.AcudienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AcudienteServicio implements ServicioBase<Acudiente> {

    @Autowired
    public AcudienteRepositorio acudienteRepositorio;//inyectar dependencia, el conoce los metodos

    @Override
    public List<Acudiente> buscarTodos() throws Exception {
        try{// (try - catch), manejo de la excepcion
            List<Acudiente> acudientes = acudienteRepositorio.findAll();
            return acudientes;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Acudiente buscarPorId(Integer id) throws Exception {
        try{
        Optional<Acudiente>acudienteOpcional = acudienteRepositorio.findById(id);
        if(acudienteOpcional.isPresent()){
            return acudienteOpcional.get();
        }else{
            throw new Exception("Usuario no encontrado");
        }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Acudiente registrar(Acudiente datosARegistrar) throws Exception {
        try{
            Acudiente acudienteGuardado = acudienteRepositorio.save(datosARegistrar);
            return acudienteGuardado;

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Acudiente actualizar(Integer id, Acudiente datosNuevos) throws Exception {
        try {

            Optional<Acudiente>acudienteOpcional = acudienteRepositorio.findById(id);
            if(acudienteOpcional.isPresent()){
                Acudiente acudienteExistente = acudienteOpcional.get();
                acudienteExistente.setNombre(datosNuevos.getNombre());
                acudienteExistente.setTelefono(datosNuevos.getTelefono());
                Acudiente acudienteActualizado = acudienteRepositorio.save(acudienteExistente);
                return acudienteActualizado;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Acudiente>acudienteOpcional = acudienteRepositorio.findById(id);
            if(acudienteOpcional.isPresent()){
                acudienteRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }
}
