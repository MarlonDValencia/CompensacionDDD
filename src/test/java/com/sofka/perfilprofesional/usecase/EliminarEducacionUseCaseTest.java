package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.gestioneducacion.commands.EliminarEducacionCommand;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.EducacionEliminada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdGestionEducacion;
import com.sofka.perfilprofesional.domain.perfil.events.NuevaReferenciaAgregada;
import com.sofka.perfilprofesional.domain.perfil.events.PerfilCreado;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EliminarEducacionUseCaseTest {
    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void eliminarEducacion(){
        //Arrange
        IdGestionEducacion idGestionEducacion = IdGestionEducacion.of("xxxxx");
        IdEducacion idEducacion = IdEducacion.of("yyyyy");
        //Act
        var command = new EliminarEducacionCommand(idGestionEducacion,idEducacion);
        var useCase = new EliminarEducacionUseCase();
        when(domainEventRepository.getEventsBy("xxxxx")).thenReturn(events());
        useCase.addRepository(domainEventRepository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idGestionEducacion.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (EducacionEliminada) events.get(0);
        //Asserts
        Assertions.assertEquals("yyyyy", event.getIdEducacion().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxxx");
    }
    private List<DomainEvent> events() {
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("yyyyy");
        return List.of(new GestionEducacionCreada(
                idHojaDeVida
        ));
    }

}
