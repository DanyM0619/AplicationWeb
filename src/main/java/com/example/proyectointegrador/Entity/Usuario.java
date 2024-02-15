package com.example.proyectointegrador.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.validation.Schema;

@Data
@Entity
@Table(schema="\"persona\"", name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String name;

    @Column(name="telefono")
    private Integer numberPhone;

    @Column(name="Correo")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(Integer numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario(int id, String name, int numberPhone, String email) {
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public Usuario(String name, int numberPhone, String email) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public Usuario() {
    }
}
