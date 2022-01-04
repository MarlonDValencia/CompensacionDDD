package com.sofka.perfilprofesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;
import com.sofka.perfilprofesional.domain.perfil.values.IdReferencia;

public class NuevaReferenciaAgregada extends DomainEvent {
    private final IdReferencia idReferencia;
    private final InfoContacto infoContacto;
    private final NombreCompleto nombreCompleto;

    public NuevaReferenciaAgregada(IdReferencia idReferencia, InfoContacto infoContacto, NombreCompleto nombreCompleto){
        super("sofka.perfilprofesional.nuevareferenciaagregada");
        this.idReferencia = idReferencia;
        this.infoContacto = infoContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public IdReferencia getIdReferencia() {
        return idReferencia;
    }

    public InfoContacto getInfoContacto() {
        return infoContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
