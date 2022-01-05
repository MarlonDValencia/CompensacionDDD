package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.experiencia.ExperienciaLaboral;
import com.sofka.perfilprofesional.domain.experiencia.commands.AgregarExperienciaLaboralCommand;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaCreada;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaLaboralAgregada;
import com.sofka.perfilprofesional.domain.experiencia.values.ConocimientosAdquiridos;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.usecase.experiencia.AgregarExperienciaLaboralUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarExperenciaLaboralUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void agregarExperienciaLaboral(){
        //Arrange
        IdExperiencia idExperiencia = IdExperiencia.of("xxxxx");
        IdExperienciaLaboral idExperienciaLaboral = IdExperienciaLaboral.of("yyyyy");
        Institucion institucion = new Institucion("Maria Jesús Mejía");
        Date date1 = new Date();
        Date date2 = new Date();
        Periodo periodo = new Periodo(date1,date2);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Matemáticas");
        //Act
        var command = new AgregarExperienciaLaboralCommand(idExperiencia,
                idExperienciaLaboral,
                institucion,
                periodo,
                conocimientosAdquiridos
        );
        var usecase = new AgregarExperienciaLaboralUseCase();
        when(domainEventRepository.getEventsBy("xxxxx")).thenReturn(events());
        usecase.addRepository(domainEventRepository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idExperiencia.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ExperienciaLaboralAgregada) events.get(0);
        //Assert
        Assertions.assertEquals("Maria Jesús Mejía", event.getInstitucion().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxxx");
    }

    private List<DomainEvent> events() {
        IdExperienciaLaboral idExperienciaLaboral = IdExperienciaLaboral.of("yyyyy");

        Institucion institucion = new Institucion("Maria Jesús Mejía");
        Date date1 = new Date();
        Date date2 = new Date();
        Periodo periodo = new Periodo(date1,date2);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Matemáticas");

        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(idExperienciaLaboral,institucion,periodo,conocimientosAdquiridos);
        return List.of(new ExperienciaCreada(
                IdHojaDeVida.of("xxxxx"),experienciaLaboral ));
    }
}
