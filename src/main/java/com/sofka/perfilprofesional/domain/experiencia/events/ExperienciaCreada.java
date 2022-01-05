package com.sofka.perfilprofesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.experiencia.ExperienciaLaboral;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;

import java.util.Set;

public class ExperienciaCreada extends DomainEvent {
    private final IdHojaDeVida idHojaDeVida;
    private final ExperienciaLaboral experienciaLaboral;

    public ExperienciaCreada(IdHojaDeVida idHojaDeVida, ExperienciaLaboral experienciaLaboral) {
        super("sofka.perfilprofesional.experienciacreada");
        this.idHojaDeVida = idHojaDeVida;
        this.experienciaLaboral = experienciaLaboral;
    }

    public ExperienciaLaboral getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }
}
