package com.sofka.perfilprofesional.usecase.experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaCreada;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.usecase.service.EnviarNotificacionService;

import java.util.List;

public class NotificarExperienciaCreadaUseCase extends UseCase<TriggeredEvent<ExperienciaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaCreada> triggeredEvent){
        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionService.class).orElseThrow();

        Boolean correoValido = service.sendMessage(
                "gestion@perfilprofesional.com",
                "Su experiencia ha sido aceptada y creada exitosamente!",
                IdExperiencia.of(event.aggregateRootId())
        );

        if (!correoValido) {
            throw new BusinessException(event.aggregateRootId(), "No se nos fue posible notificar la creacion de una experiencia para el usuario");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
