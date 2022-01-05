package com.sofka.perfilprofesional.domain.hojadevida.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;

public class HojaDeVidaCreada  extends DomainEvent {
    public HojaDeVidaCreada(){
        super("sofka.perfilprofesional.hojadevidacreada");
    }
}
