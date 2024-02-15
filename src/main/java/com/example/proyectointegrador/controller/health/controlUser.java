package com.example.proyectointegrador.controller.health;

import com.example.proyectointegrador.Entity.Usuario;
import com.example.proyectointegrador.Services.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class controlUser {

    @Autowired
    private Servicio servicio;

    //Metodo de visualizacion
    @GetMapping(path = "/ver")
    public List<Usuario> viewUser(){
        return this.servicio.viewUser();
    }

    //Metodo de agregar o creacion
    @PostMapping(path="/crear")
    public ResponseEntity<Object> addUser(@RequestBody Usuario user){
        Optional<Object> addUser = Optional.ofNullable(servicio.addUser(user));
        if (addUser.isPresent()) {
            return new ResponseEntity<>("Se creo el usuario", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("No se creo el usuario",HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //Metodo de actualizacion
    @PutMapping(path = "/update/{Id}")
    public ResponseEntity<Object> Update(@PathVariable Integer Id, @RequestBody Usuario userRegistration){
        return this.servicio.updateUser(Id, userRegistration);
    }

    //Metodo de eliminacion
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        return  this.servicio.delete(id);
    }

}
