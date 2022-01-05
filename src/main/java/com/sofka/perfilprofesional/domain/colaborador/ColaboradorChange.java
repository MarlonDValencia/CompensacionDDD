package com.sofka.perfilprofesional.domain.colaborador;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.colaborador.events.ColaboradorCreado;

import java.util.Objects;

public class ColaboradorChange extends EventChange {
    public ColaboradorChange(Colaborador colaborador){
        apply((ColaboradorCreado event) -> {
            colaborador.area= Objects.requireNonNull(event.getArea());
            colaborador.genero = Objects.requireNonNull(event.getGenero());
            colaborador.cedula = Objects.requireNonNull(event.getCedula());
            colaborador.fechaNacimiento = Objects.requireNonNull(event.getFechaNacimiento());
            colaborador.idHojaDeVida = Objects.requireNonNull(event.getIdHojaDeVida());
            colaborador.nombreCompleto = Objects.requireNonNull(event.getNombreCompleto());
        });
    }
}
