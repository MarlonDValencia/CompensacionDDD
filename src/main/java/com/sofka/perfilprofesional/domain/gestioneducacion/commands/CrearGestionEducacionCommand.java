package com.sofka.perfilprofesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;

public class CrearGestionEducacionCommand extends Command {
    private final IdHojaDeVida idHojaDeVida;

    public CrearGestionEducacionCommand(IdHojaDeVida idHojaDeVida) {
        this.idHojaDeVida = idHojaDeVida;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }
}
