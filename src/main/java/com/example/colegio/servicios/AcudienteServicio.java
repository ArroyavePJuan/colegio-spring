package com.example.colegio.servicios;

import com.example.colegio.Entidades.Acudiente;
import com.example.colegio.repositorios.AcudienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

public class AcudienteServicio implements ServicioBase<Acudiente> {

    @Autowired
    protected AcudienteRepositorio acudienteRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Acudiente> buscarTodos() throws Exception {
        try{
            List<Acudiente>acudientes=acudienteRepositorio.findAll();
            return acudientes;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Acudiente buscarPorId(Integer id) throws Exception {
        try{
          Optional<Acudiente>acudienteOpcional =acudienteRepositorio.findById(id);
          if(acudienteOpcional.isPresent()){
              return acudienteOpcional.get();
          }else{
              throw new Exception("Usuario no encontrado");
          }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Acudiente registrar(Acudiente datosARegistrar) throws Exception {
        try{
            Acudiente acudianteGuardado=acudienteRepositorio.save(datosARegistrar);
            return acudianteGuardado;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Acudiente actualizar(Integer id, Acudiente datosNuevos) throws Exception {
        try{
            Optional<Acudiente>acudienteOpcional =acudienteRepositorio.findById(id);
            if(acudienteOpcional.isPresent()){
                Acudiente acudienteExistente=acudienteOpcional.get();
                acudienteExistente.setNombre(datosNuevos.getNombre());
                acudienteExistente.setTelefono(datosNuevos.getTelefono());
                Acudiente acudianteActualizado=acudienteRepositorio.save(acudienteExistente);
                return acudianteActualizado;
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

            Optional<Acudiente>acudienteOpcional =acudienteRepositorio.findById(id);
            if(acudienteOpcional.isPresent()){
                acudienteRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
