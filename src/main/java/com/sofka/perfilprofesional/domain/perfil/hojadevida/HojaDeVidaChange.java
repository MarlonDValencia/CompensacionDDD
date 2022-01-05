package com.sofka.perfilprofesional.domain.perfil.hojadevida;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.perfil.hojadevida.events.HojaDeVidaCreada;

public class HojaDeVidaChange extends EventChange {
    public HojaDeVidaChange(HojaDeVida hojaDeVida){
        apply((HojaDeVidaCreada event) -> {
        });
    }
}
