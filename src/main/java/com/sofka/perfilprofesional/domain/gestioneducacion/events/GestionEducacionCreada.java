package com.sofka.perfilprofesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;

public class GestionEducacionCreada extends DomainEvent {
    private final IdHojaDeVida idHojaDeVida;

    public GestionEducacionCreada(IdHojaDeVida idHojaDeVida) {
        super("sofka.perfilprofesional.gestioneducacioncreada");
        this.idHojaDeVida = idHojaDeVida;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }
}
