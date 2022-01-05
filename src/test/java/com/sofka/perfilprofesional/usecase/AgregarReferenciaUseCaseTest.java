package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.experiencia.ExperienciaLaboral;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaCreada;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaLaboralAgregada;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.perfilprofesional.domain.generics.*;
import com.sofka.perfilprofesional.domain.perfil.commands.AgregarReferenciaCommand;
import com.sofka.perfilprofesional.domain.perfil.events.NuevaReferenciaAgregada;
import com.sofka.perfilprofesional.domain.perfil.events.PerfilCreado;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdReferencia;
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
class AgregarReferenciaUseCaseTest {
    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void agregarReferencia(){
        //Arrange
        IdPerfil idPerfil = IdPerfil.of("xxxxx");
        IdReferencia idReferencia = IdReferencia.of("yyyyy");
        InfoContacto info = new InfoContacto("Telefono : 3227638978");
        NombreCompleto nombreCompleto = new NombreCompleto("Marlon", "Valencia");
        //Act
        var command = new AgregarReferenciaCommand(idPerfil,
                idReferencia,
                info,
                nombreCompleto);
        var useCase = new AgregarReferenciaUseCase();
        when(domainEventRepository.getEventsBy("xxxxx")).thenReturn(events());
        useCase.addRepository(domainEventRepository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPerfil.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (NuevaReferenciaAgregada) events.get(0);
        //Assert
        Assertions.assertEquals("Telefono : 3227638978", event.getInfoContacto().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxxx");
    }

    private List<DomainEvent> events() {
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("yyyyy");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("a");
        InfoContacto infoContacto = new InfoContacto("");
        return List.of(new PerfilCreado(
                idHojaDeVida,
                fotoDePerfil,
                infoContacto));
    }
}
