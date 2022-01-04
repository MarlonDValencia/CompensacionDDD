package com.sofka.perfilprofesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperienciaLaboral;

public class EliminarExperienciaLaboralCommand extends Command {
    private final IdExperienciaLaboral idExperienciaLaboral;

    public EliminarExperienciaLaboralCommand(IdExperienciaLaboral idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }
}
