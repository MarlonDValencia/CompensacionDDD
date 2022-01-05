package com.sofka.perfilprofesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdGestionEducacion;

public class EliminarEducacionCommand extends Command {
    private final IdGestionEducacion idGestionEducacion;
    private final IdEducacion idEducacion;

    public EliminarEducacionCommand(IdGestionEducacion idGestionEducacion,IdEducacion idEducacion) {
        this.idGestionEducacion = idGestionEducacion;
        this.idEducacion = idEducacion;
    }

    public IdGestionEducacion getIdGestionEducacion() {
        return idGestionEducacion;
    }

    public IdEducacion getIdEducacion() {
        return idEducacion;
    }
}
