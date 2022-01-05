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
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = new Date();
        try {
            firstDate = sdf.parse(new Date().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date secondDate = new Date();
        try {
            secondDate = sdf.parse(String.valueOf(command.getFechaNacimiento()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = secondDate.getTime() - firstDate.getTime();
        if (diff < 6.570) {
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
