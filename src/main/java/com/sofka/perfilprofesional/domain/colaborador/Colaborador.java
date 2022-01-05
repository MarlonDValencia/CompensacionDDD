package com.sofka.perfilprofesional.domain.colaborador;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.colaborador.events.ColaboradorCreado;
import com.sofka.perfilprofesional.domain.colaborador.values.*;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;

import java.util.List;

public class Colaborador extends AggregateEvent<IdColaborador> {
    public IdHojaDeVida idHojaDeVida;
    public FechaNacimiento fechaNacimiento;
    public NombreCompleto nombreCompleto;
    public Cedula cedula;
    public Genero genero;
    public Area area;

    public Colaborador(IdColaborador idColaborador, IdHojaDeVida idHojaDeVida, FechaNacimiento fechaNacimiento, NombreCompleto nombreCompleto, Cedula cedula, Genero genero, Area area) {
        super(idColaborador);
        subscribe(new ColaboradorChange(this));
        appendChange(new ColaboradorCreado(idHojaDeVida,fechaNacimiento,nombreCompleto,cedula,genero,area)).apply();
    }

    private Colaborador(IdColaborador idColaborador){
        super(idColaborador);
        subscribe(new ColaboradorChange(this));
    }

    public static Colaborador from(IdColaborador idColaborador, List<DomainEvent> events){
        var colaborador = new Colaborador(idColaborador);
        events.forEach(colaborador::applyEvent);
        return colaborador;
    }

    public IdHojaDeVida idHojaDeVida() {
        return idHojaDeVida;
    }

    public FechaNacimiento fechaNacimiento() {
        return fechaNacimiento;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }

    public Cedula cedula() {
        return cedula;
    }

    public Genero genero() {
        return genero;
    }

    public Area area() {
        return area;
    }
}
