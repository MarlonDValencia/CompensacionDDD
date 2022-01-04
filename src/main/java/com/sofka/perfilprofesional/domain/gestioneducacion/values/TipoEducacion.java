package com.sofka.perfilprofesional.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoEducacion implements ValueObject<String> {
    private final String tipoEducacion;

    public TipoEducacion(String tipoEducacion){
        this.tipoEducacion = Objects.requireNonNull(tipoEducacion, "El tipo de educacion no puede ser nula");
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TipoEducacion educationKind = (TipoEducacion) o;
        return Objects.equals(tipoEducacion,educationKind.tipoEducacion);
    }

    @Override
    public int hashCode(){
        return Objects.hash(tipoEducacion);
    }

    @Override
    public String value(){
        return tipoEducacion;
    }
}
