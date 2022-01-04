package com.sofka.perfilprofesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;
import com.sofka.perfilprofesional.domain.perfil.values.IdReferencia;

public class AgregarReferenciaCommand extends Command {
    private final IdReferencia idReferencia;
    private final InfoContacto infoContacto;
    private final NombreCompleto nombreCompleto;

    public AgregarReferenciaCommand(IdReferencia idReferencia, InfoContacto infoContacto, NombreCompleto nombreCompleto) {
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
