package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.experiencia.ExperienciaLaboral;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaCreada;
import com.sofka.perfilprofesional.domain.experiencia.values.ConocimientosAdquiridos;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.usecase.experiencia.CalcularTiempoExperienciaLaboralUseCase;
import com.sofka.perfilprofesional.usecase.service.CalcularPeriodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalcularTiempoExperienciaLaboralUseCaseTest {
    @Mock
    CalcularPeriodoService calcularPeriodoService;
    @Mock
    DomainEventRepository repository;

    @Test
    void calcularTiempoExperienciaLaboral(){
        //Arrange
        IdExperiencia idExperiencia = IdExperiencia.of("xxxxx");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("yyyyy");
        IdExperienciaLaboral idExperienciaLaboral = IdExperienciaLaboral.of("zzzzz");
        Institucion institucion = new Institucion("Maria Jesús Mejía");
        Date date1 = new Date();
        Date date2 = new Date();
        Periodo periodo = new Periodo(date1,date2);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Matemáticas");
        ExperienciaLaboral experienciaLaboral= new ExperienciaLaboral(idExperienciaLaboral,institucion,periodo,conocimientosAdquiridos);
        //Act
        var event = new ExperienciaCreada(idHojaDeVida,experienciaLaboral);
        event.setAggregateRootId(idExperiencia.value());
        var useCase = new CalcularTiempoExperienciaLaboralUseCase();

        when(calcularPeriodoService.calcularTiempo(
                idExperiencia,
                periodo
        )).thenReturn(10d);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(calcularPeriodoService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idExperiencia.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();
        //Asserts
        verify(calcularPeriodoService).calcularTiempo(
                idExperiencia,
                periodo
        );
    }

    @Test
    void calcularTiempoExperienciaLaboralFails(){
        //Arrange
        IdExperiencia idExperiencia = IdExperiencia.of("xxxxx");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("yyyyy");
        IdExperienciaLaboral idExperienciaLaboral = IdExperienciaLaboral.of("zzzzz");
        Institucion institucion = new Institucion("Maria Jesús Mejía");
        Date date1 = new Date();
        Date date2 = new Date();
        Periodo periodo = new Periodo(date1,date2);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Matemáticas");
        ExperienciaLaboral experienciaLaboral= new ExperienciaLaboral(idExperienciaLaboral,institucion,periodo,conocimientosAdquiridos);
        //Act
        var event = new ExperienciaCreada(idHojaDeVida,experienciaLaboral);
        event.setAggregateRootId(idExperiencia.value());
        var useCase = new CalcularTiempoExperienciaLaboralUseCase();

        when(calcularPeriodoService.calcularTiempo(
                idExperiencia,
                periodo
        )).thenReturn(-15d);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(calcularPeriodoService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idExperiencia.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();
        //Asserts
        verify(calcularPeriodoService).calcularTiempo(
                idExperiencia,
                periodo
        );
    }

    private List<DomainEvent> events() {
        IdExperienciaLaboral idExperienciaLaboral = IdExperienciaLaboral.of("zzzzz");
        Institucion institucion = new Institucion("Maria Jesús Mejía");
        Date date1 = new Date();
        Date date2 = new Date();
        Periodo periodo = new Periodo(date1,date2);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Matemáticas");
        ExperienciaLaboral experienciaLaboral= new ExperienciaLaboral(idExperienciaLaboral,institucion,periodo,conocimientosAdquiridos);
        return List.of(
                new ExperienciaCreada(
                        IdHojaDeVida.of("yyyyy"),
                        experienciaLaboral
                )
        );
    }
}
