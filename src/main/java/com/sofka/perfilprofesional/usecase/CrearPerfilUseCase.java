package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.perfilprofesional.domain.perfil.Perfil;
import com.sofka.perfilprofesional.domain.perfil.commands.CrearPerfilCommand;

public class CrearPerfilUseCase extends UseCase<RequestCommand<CrearPerfilCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPerfilCommand> requestCommand){
        var command = requestCommand.getCommand();
        if(command.getInfoContacto().value().length() > 30){
            throw new BusinessException(command.getInfoContacto().value(), "La información de contacto no puede superar los 30 caracteres");
        }
        var perfil = new Perfil(command.getIdPerfil(), command.getIdHojaDeVida(), command.getFotoDePerfil(),command.getInfoContacto());

        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
