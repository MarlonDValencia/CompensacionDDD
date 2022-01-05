package com.sofka.perfilprofesional.usecase.perfil;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.perfilprofesional.domain.perfil.events.PerfilCreado;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;
import com.sofka.perfilprofesional.usecase.service.EnviarNotificacionPerfilService;

import java.util.List;

public class NotificarPerfilCreadoUseCase extends UseCase<TriggeredEvent<PerfilCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PerfilCreado> triggeredEvent){
        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionPerfilService.class).orElseThrow();

        Boolean correoValido = service.sendMessage(
                "gestion@perfilprofesional.com",
                "Su perfil creado satisfactoriamente",
                IdPerfil.of(event.aggregateRootId())
        );

        if (!correoValido) {
            throw new BusinessException(event.aggregateRootId(), "No se nos hizo posible crear el pefil");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
