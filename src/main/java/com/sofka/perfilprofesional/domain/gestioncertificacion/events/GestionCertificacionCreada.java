package com.sofka.perfilprofesional.domain.gestioncertificacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.gestioncertificacion.Certificacion;

public class GestionCertificacionCreada extends DomainEvent {
    public final IdHojaDeVida idHojaDeVida;
    public final Certificacion certificacion;

    public GestionCertificacionCreada(IdHojaDeVida idHojaDeVida, Certificacion certificacion) {
        super("sofka.perfilprofesional.gestioncertificacioncreada");
        this.idHojaDeVida = idHojaDeVida;
        this.certificacion = certificacion;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }
}
