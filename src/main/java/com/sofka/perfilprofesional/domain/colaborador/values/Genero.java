package com.sofka.perfilprofesional.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genero implements ValueObject<String> {
    private final String genero;

    public Genero(String genero){
        this.genero = Objects.requireNonNull(genero, "El género no puede ser nulo");
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Genero genre = (Genero) o;
        return Objects.equals(genero,genre.genero);
    }

    @Override
    public int hashCode(){
        return Objects.hash(genero);
    }

    @Override
    public String value(){
        return genero;
    }
}
