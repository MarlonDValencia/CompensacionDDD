package com.sofka.perfilprofesional.domain.experiencia.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;

import java.util.Objects;

public class ConocimientosAdquiridos implements ValueObject<String> {
    private final String conocimientos;

    public ConocimientosAdquiridos(String conocimientos){
        this.conocimientos = Objects.requireNonNull(conocimientos, "los conocimientos no pueden ser nulos");
    }

    public ConocimientosAdquiridos modificarConocimientosAdquiridos(String conocimientos) {
        return new ConocimientosAdquiridos(conocimientos);
    }

    @Override
    public String value(){
        return conocimientos;
    }
}
