package com.example.proyectointegrador.Services;


import com.example.proyectointegrador.Entity.Usuario;
import com.example.proyectointegrador.Repository.IuserRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class Servicio {

    @Autowired
    private IuserRpository iuserRpository;

    //Metodo de ver, observar
    public List<Usuario> viewUser(){
        return this.iuserRpository.findAll();
    }

    //Metodo de Agregar
    public ResponseEntity<Object> addUser(Usuario user){
        Optional<Usuario>respuesta = iuserRpository.findByName(user.getName());
        if (respuesta.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            Usuario guardarUser = iuserRpository.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    //Metodo de Actualizar

    public ResponseEntity<Object> updateUser(Integer Id, Usuario userRegistration) {
        Map<String, Object> message = new HashMap<>(); // Crea un nuevo mapa para almacenar los datos de la respuesta

        Optional<Usuario> existingUserOptional = iuserRpository.findById(Id);

        if (existingUserOptional.isPresent()) {
            Usuario existingUser = existingUserOptional.get();
            existingUser.setName(userRegistration.getName());
            existingUser.setEmail(userRegistration.getEmail());
            existingUser.setNumberPhone(userRegistration.getNumberPhone());

            Usuario updatedUser = iuserRpository.save(existingUser);
            message.put("message", "Se actualizó correctamente la base de Usuario");
            message.put("Datos", updatedUser);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("error", true);
            message.put("Aviso", "No se encontró el usuario deseado con el Id proporcionado");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    //Metodo de Eliminar
    public ResponseEntity<Object> delete(Integer id){
        boolean existing= this.iuserRpository.existsById(id);
        Map<String, Object> message = new HashMap<>();
        if(!existing){
            message.put("error", true);
            message.put("Aviso", "No existe el usuario  ");
            return new ResponseEntity<>(message,
                    HttpStatus.CONFLICT);
        }
        iuserRpository.deleteById(id);
        message.put("Avsio", "Usuario eliminado! ");
        return new ResponseEntity<>(message,
                HttpStatus.ACCEPTED);
    }
}
