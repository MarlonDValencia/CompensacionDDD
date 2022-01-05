package com.sofka.perfilprofesional.usecase.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.perfilprofesional.domain.perfil.Perfil;
import com.sofka.perfilprofesional.domain.perfil.commands.AgregarReferenciaCommand;

public class AgregarReferenciaUseCase extends UseCase<RequestCommand<AgregarReferenciaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarReferenciaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var perfil = Perfil.from(command.getIdPerfil(),retrieveEvents());

        perfil.agregarNuevaReferencia(command.getInfoContacto(),command.getNombreCompleto());
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
