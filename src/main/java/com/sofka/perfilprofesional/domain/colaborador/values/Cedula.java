package com.sofka.perfilprofesional.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cedula implements ValueObject<String> {
    private final String cedula;

    public Cedula(String cedula){
        this.cedula = Objects.requireNonNull(cedula, "la cedula no puede ser nula");
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Cedula ID = (Cedula) o;
        return Objects.equals(cedula,ID.cedula);
    }

    @Override
    public int hashCode(){
        return Objects.hash(cedula);
    }

    @Override
    public String value(){
        return cedula;
    }
}
