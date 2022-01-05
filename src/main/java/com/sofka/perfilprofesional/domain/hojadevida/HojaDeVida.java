package com.sofka.perfilprofesional.domain.hojadevida;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.hojadevida.events.HojaDeVidaCreada;

import java.util.List;

public class HojaDeVida extends AggregateEvent<IdHojaDeVida> {
    public HojaDeVida(IdHojaDeVida idHojaDeVida) {
        super(idHojaDeVida);
        subscribe(new HojaDeVidaChange(this));
        appendChange(new HojaDeVidaCreada()).apply();
    }

    public static HojaDeVida from(IdHojaDeVida idHojaDeVida, List<DomainEvent> events){
        var hojaDeVida = new HojaDeVida(idHojaDeVida);
        events.forEach(hojaDeVida::applyEvent);
        return hojaDeVida;
    }
}
