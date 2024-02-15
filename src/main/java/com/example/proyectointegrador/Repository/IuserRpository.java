package com.example.proyectointegrador.Repository;

import com.example.proyectointegrador.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IuserRpository extends JpaRepository <Usuario, Integer>{

    Optional<Usuario> findByName(String name);
}
