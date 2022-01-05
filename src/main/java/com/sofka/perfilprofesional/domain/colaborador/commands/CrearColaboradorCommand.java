package com.sofka.perfilprofesional.domain.colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.colaborador.values.Area;
import com.sofka.perfilprofesional.domain.colaborador.values.Cedula;
import com.sofka.perfilprofesional.domain.colaborador.values.FechaNacimiento;
import com.sofka.perfilprofesional.domain.colaborador.values.Genero;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;

public class CrearColaboradorCommand extends Command {
    public IdHojaDeVida idHojaDeVida;
    public FechaNacimiento fechaNacimiento;
    public NombreCompleto nombreCompleto;
    public Cedula cedula;
    public Genero genero;
    public Area area;

    public CrearColaboradorCommand(IdHojaDeVida idHojaDeVida, FechaNacimiento fechaNacimiento, NombreCompleto nombreCompleto, Cedula cedula, Genero genero, Area area) {
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
