package com.sofka.perfilprofesional.domain.gestioncertificacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.gestioncertificacion.events.GestionCertificacionCreada;
import com.sofka.perfilprofesional.domain.gestioncertificacion.values.IdGestionCertificacion;

import java.util.List;

public class GestionCertificacion  extends AggregateEvent<IdGestionCertificacion> {
    protected IdHojaDeVida idHojaDeVida;
    protected Certificacion certificacion;

    public GestionCertificacion(IdGestionCertificacion idGestionCertificacion, IdHojaDeVida idHojaDeVida, Certificacion certificacion) {
        super(idGestionCertificacion);
        subscribe(new GestionCertificacionChange(this));
        appendChange(new GestionCertificacionCreada(idHojaDeVida,certificacion)).apply();
    }

    private GestionCertificacion(IdGestionCertificacion idGestionCertificacion){
        super(idGestionCertificacion);
        subscribe(new GestionCertificacionChange(this));
    }

    public static GestionCertificacion from(IdGestionCertificacion idGestionCertificacion, List<DomainEvent> events){
        var gestionCertificacion = new GestionCertificacion(idGestionCertificacion);
        events.forEach(gestionCertificacion::applyEvent);
        return gestionCertificacion;
    }

    public IdHojaDeVida idHojaDeVida() {
        return idHojaDeVida;
    }

    public Certificacion certificacion() {
        return certificacion;
    }
}
