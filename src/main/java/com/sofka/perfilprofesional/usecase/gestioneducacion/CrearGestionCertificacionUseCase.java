package com.sofka.perfilprofesional.usecase.gestioneducacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.perfilprofesional.domain.gestioncertificacion.GestionCertificacion;
import com.sofka.perfilprofesional.domain.gestioncertificacion.commands.CrearGestionCertificacionCommand;

import java.util.Date;

public class CrearGestionCertificacionUseCase extends UseCase<RequestCommand<CrearGestionCertificacionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearGestionCertificacionCommand> requestCommand){
        var command = requestCommand.getCommand();
        if(command.getCertificacion().periodo().value().fechaFin().before(new Date())){
            throw new BusinessException(command.getCertificacion().periodo().value().fechaFin().toString(), "La certificacion ingresada ya caducó");
        }
        var gestionCertificacion = new GestionCertificacion(
                command.getIdGestionCertificacion(),
                command.getIdHojaDeVida(),
                command.getCertificacion()
        );

        emit().onResponse(new ResponseEvents(gestionCertificacion.getUncommittedChanges()));
    }
}
