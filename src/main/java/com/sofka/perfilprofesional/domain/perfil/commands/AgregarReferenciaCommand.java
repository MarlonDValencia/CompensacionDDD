package com.sofka.perfilprofesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdReferencia;

public class AgregarReferenciaCommand extends Command {
    private final IdPerfil idPerfil;
    private final IdReferencia idReferencia;
    private final InfoContacto infoContacto;
    private final NombreCompleto nombreCompleto;

    public AgregarReferenciaCommand(IdPerfil idPerfil,IdReferencia idReferencia, InfoContacto infoContacto, NombreCompleto nombreCompleto) {
        this.idPerfil = idPerfil;
        this.idReferencia = idReferencia;
        this.infoContacto = infoContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public IdPerfil getIdPerfil() {
        return idPerfil;
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
