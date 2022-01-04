package com.sofka.perfilprofesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;

public class EducacionEliminada extends DomainEvent {
    private final IdEducacion idEducacion;

    public EducacionEliminada(IdEducacion idEducacion) {
        super("sofka.perfilprofesional.educacioneliminada");
        this.idEducacion = idEducacion;
    }

    public IdEducacion getIdEducacion() {
        return idEducacion;
    }
}
