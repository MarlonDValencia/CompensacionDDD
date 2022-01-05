package com.sofka.perfilprofesional.domain.colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;
import com.sofka.perfilprofesional.domain.colaborador.values.Area;
import com.sofka.perfilprofesional.domain.colaborador.values.Cedula;
import com.sofka.perfilprofesional.domain.colaborador.values.FechaNacimiento;
import com.sofka.perfilprofesional.domain.colaborador.values.Genero;


public class ColaboradorCreado extends DomainEvent {
    public IdHojaDeVida idHojaDeVida;
    public FechaNacimiento fechaNacimiento;
    public NombreCompleto nombreCompleto;
    public Cedula cedula;
    public Genero genero;
    public Area area;

    public ColaboradorCreado(IdHojaDeVida idHojaDeVida, FechaNacimiento fechaNacimiento, NombreCompleto nombreCompleto, Cedula cedula, Genero genero, Area area) {
        super("sofka.perfilprofesional.colaboradorcreado");
        this.idHojaDeVida = idHojaDeVida;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.genero = genero;
        this.area = area;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public Genero getGenero() {
        return genero;
    }

    public Area getArea() {
        return area;
    }
}
