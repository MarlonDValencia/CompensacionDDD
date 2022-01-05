package com.sofka.perfilprofesional.domain.generics;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;

import java.util.Objects;

public class Institucion implements ValueObject<String> {
    private final String nombre;

    public Institucion(String nombre){
        this.nombre = Objects.requireNonNull(nombre, "El nombre de la institucion no puede ser nulo");
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Institucion Institution = (Institucion) o;
        return Objects.equals(nombre,Institution.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }

    @Override
    public String value(){
        return nombre;
    }
}
