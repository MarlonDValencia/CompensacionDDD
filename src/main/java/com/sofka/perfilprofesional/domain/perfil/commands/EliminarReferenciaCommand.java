package com.sofka.perfilprofesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.perfil.values.IdReferencia;

public class EliminarReferenciaCommand extends Command {
    private final IdReferencia idReferencia;

    public EliminarReferenciaCommand(IdReferencia idReferencia) {
        this.idReferencia = idReferencia;
    }

    public IdReferencia getIdReferencia() {
        return idReferencia;
    }
}
