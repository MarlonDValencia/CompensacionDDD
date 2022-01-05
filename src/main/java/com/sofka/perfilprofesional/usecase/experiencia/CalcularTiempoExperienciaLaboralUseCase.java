package com.sofka.perfilprofesional.usecase.experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaCreada;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.usecase.service.CalcularPeriodoService;

import java.util.Date;

public class CalcularTiempoExperienciaLaboralUseCase extends UseCase<TriggeredEvent<ExperienciaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaCreada> triggeredEvent){
        var event = triggeredEvent.getDomainEvent();
        var idExperiencia = IdExperiencia.of(event.aggregateRootId());
        var periodo = event.getExperienciaLaboral().periodo();
        var service = getService(CalcularPeriodoService.class).orElseThrow();

        Double tiempoLaborado =
                service.calcularTiempo(
                        idExperiencia,
                        periodo
                );
        if (tiempoLaborado <= 0) {
            throw new BusinessException(event.aggregateRootId(), "El tiempo laborado debe ser mayor a cero para ser considerado experiencia laboral");
        }
    }
}
