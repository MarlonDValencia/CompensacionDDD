package com.sofka.perfilprofesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;

import java.util.Objects;

public class CrearExperienciaCommand extends Command {
    private final IdHojaDeVida idHojaDeVida;

    public CrearExperienciaCommand(IdHojaDeVida idHojaDeVida) {
        this.idHojaDeVida = Objects.requireNonNull(idHojaDeVida);
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }
}
