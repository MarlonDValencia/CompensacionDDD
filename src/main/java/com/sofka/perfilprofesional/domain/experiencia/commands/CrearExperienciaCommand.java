package com.sofka.perfilprofesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;

public class CrearExperienciaCommand extends Command {
    private final IdHojaDeVida idHojaDeVida;

    public CrearExperienciaCommand(IdHojaDeVida idHojaDeVida) {
        this.idHojaDeVida = idHojaDeVida;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }
}
