package com.sofka.perfilprofesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.perfil.values.IdReferencia;

public class ReferenciaEliminada extends DomainEvent{
    private final IdReferencia idReferencia;

    public ReferenciaEliminada(IdReferencia idReferencia){
        super("sofka.perfilprofesional.referenciaeliminada");
        this.idReferencia = idReferencia;
    }

    public IdReferencia getIdReferencia() {
        return idReferencia;
    }
}
