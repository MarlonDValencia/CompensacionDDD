package com.sofka.perfilprofesional.usecase.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.perfilprofesional.domain.gestioneducacion.GestionEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.commands.EliminarEducacionCommand;

public class EliminarEducacionUseCase extends UseCase<RequestCommand<EliminarEducacionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarEducacionCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var gestionEducacion = GestionEducacion.from(command.getIdGestionEducacion(),retrieveEvents());

        gestionEducacion.eliminarEducacion(command.getIdEducacion());
        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));
    }

}
