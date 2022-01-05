package com.sofka.perfilprofesional.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class FechaNacimiento implements ValueObject<Date> {
    private final Date fecha;

    public FechaNacimiento(Date fecha){
        this.fecha = Objects.requireNonNull(fecha);
        if(fecha.before(new Date())){
            throw new IllegalArgumentException("No puedes poner una fecha futura");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaNacimiento fechaNacimiento = (FechaNacimiento) o;
        return Objects.equals(fecha, fechaNacimiento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }

    @Override
    public Date value() {
        return fecha;
    }
}
