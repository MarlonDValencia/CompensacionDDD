package com.sofka.perfilprofesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;

public class EliminarEducacionCommand extends Command {
    private final IdEducacion idEducacion;

    public EliminarEducacionCommand(IdEducacion idEducacion) {
        this.idEducacion = idEducacion;
    }

    public IdEducacion getIdEducacion() {
        return idEducacion;
    }
}
