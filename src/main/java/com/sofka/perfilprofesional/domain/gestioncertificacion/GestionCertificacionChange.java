package com.sofka.perfilprofesional.domain.gestioncertificacion;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.gestioncertificacion.events.GestionCertificacionCreada;

import java.util.Objects;

public class GestionCertificacionChange extends EventChange {
    public GestionCertificacionChange(GestionCertificacion gestionCertificacion){
        apply((GestionCertificacionCreada event)-> {
            gestionCertificacion.idHojaDeVida = Objects.requireNonNull(event.getIdHojaDeVida());
            gestionCertificacion.certificacion = Objects.requireNonNull(event.getCertificacion());
        });
    }
}
