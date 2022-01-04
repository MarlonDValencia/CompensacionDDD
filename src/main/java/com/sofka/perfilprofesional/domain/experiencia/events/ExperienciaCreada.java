package com.sofka.perfilprofesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;

public class ExperienciaCreada extends DomainEvent {
    private final IdHojaDeVida idHojaDeVida;

    public ExperienciaCreada(IdHojaDeVida idHojaDeVida) {
        super("sofka.perfilprofesional.experienciacreada");
        this.idHojaDeVida = idHojaDeVida;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }
}
