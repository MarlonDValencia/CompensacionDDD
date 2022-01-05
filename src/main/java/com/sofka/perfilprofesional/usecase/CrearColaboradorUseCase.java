package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.perfilprofesional.domain.colaborador.Colaborador;
import com.sofka.perfilprofesional.domain.colaborador.commands.CrearColaboradorCommand;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CrearColaboradorUseCase extends UseCase<RequestCommand<CrearColaboradorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearColaboradorCommand> requestCommand) {
        var command = requestCommand.getCommand();
        if (command.getFechaNacimiento().value().after(new Date(2004,1,1))) {
            throw new BusinessException(command.getFechaNacimiento().value().toString(), "El colaborador debe tener minimo 18 años");
        }
        var colaborador = new Colaborador(command.getIdColaborador(),
                command.getIdHojaDeVida(),
                command.getFechaNacimiento(),
                command.getNombreCompleto(),
                command.getCedula(),
                command.getGenero(),
                command.getArea());
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
