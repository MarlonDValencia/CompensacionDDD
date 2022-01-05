package com.sofka.perfilprofesional.usecase.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.perfilprofesional.domain.experiencia.Experiencia;
import com.sofka.perfilprofesional.domain.experiencia.commands.AgregarExperienciaLaboralCommand;

public class AgregarExperienciaLaboralUseCase extends UseCase<RequestCommand<AgregarExperienciaLaboralCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarExperienciaLaboralCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var experiencia = Experiencia.from(command.getIdExperiencia(),retrieveEvents());

        experiencia.agregarExperienciaLaboral(command.getInstitucion(),command.getPeriodo(),command.getConocimientosAdquiridos());
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
