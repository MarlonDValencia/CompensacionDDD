package com.sofka.perfilprofesional.domain.colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.colaborador.values.*;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;

import java.util.Objects;

public class CrearColaboradorCommand extends Command {
    public IdColaborador idColaborador;
    public IdHojaDeVida idHojaDeVida;
    public FechaNacimiento fechaNacimiento;
    public NombreCompleto nombreCompleto;
    public Cedula cedula;
    public Genero genero;
    public Area area;

    public CrearColaboradorCommand(IdColaborador idColaborador,IdHojaDeVida idHojaDeVida, FechaNacimiento fechaNacimiento, NombreCompleto nombreCompleto, Cedula cedula, Genero genero, Area area) {
        this.idColaborador = Objects.requireNonNull(idColaborador);
        this.idHojaDeVida = Objects.requireNonNull(idHojaDeVida);
        this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.cedula = Objects.requireNonNull(cedula);
        this.genero = Objects.requireNonNull(genero);
        this.area = Objects.requireNonNull(area);
    }

    public IdColaborador getIdColaborador() {
        return idColaborador;
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
