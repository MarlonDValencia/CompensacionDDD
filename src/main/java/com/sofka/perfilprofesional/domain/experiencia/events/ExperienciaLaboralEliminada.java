package com.sofka.perfilprofesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;

public class ExperienciaLaboralEliminada extends DomainEvent {
    private final IdExperienciaLaboral idExperienciaLaboral;

    public ExperienciaLaboralEliminada(IdExperienciaLaboral idExperienciaLaboral) {
        super("sofka.perfilprofesional.experiencialaboraleliminada");
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }
}
