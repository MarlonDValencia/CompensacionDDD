package com.sofka.perfilprofesional.domain.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Periodo implements ValueObject<Periodo.Properties> {
    private final Date fechaInicio;
    private final Date fechaFin;

    public Periodo(Date fechaInicio, Date fechaFin){
        this.fechaInicio = Objects.requireNonNull(fechaInicio, "La fecha de inicio no puede ser nulo");
        this.fechaFin = Objects.requireNonNull(fechaFin, "La fecha final no puede ser nulo");

        if(fechaInicio.before(fechaFin)){
            throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a la fecha final");
        }

        if(fechaFin.after(fechaInicio)){
            throw new IllegalArgumentException("La fecha de fin no puede ser posterior a la fecha inicial");
        }
    }

    public Properties value() {
        return new Properties() {
            @Override
            public Date fechaInicio() {
                return fechaInicio;
            }

            @Override
            public Date fechaFin() {
                return fechaFin;
            }
        };
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Periodo period = (Periodo) o;
        return Objects.equals(fechaInicio, period.fechaInicio) && Objects.equals(fechaFin, period.fechaFin);
    }

    @Override
    public int hashCode(){
        return Objects.hash(fechaInicio,fechaFin);
    }

    public interface Properties {
        Date fechaInicio();
        Date fechaFin();
    }
}
