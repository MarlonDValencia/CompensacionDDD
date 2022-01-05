package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.perfil.events.PerfilCreado;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;
import com.sofka.perfilprofesional.usecase.perfil.NotificarPerfilCreadoUseCase;
import com.sofka.perfilprofesional.usecase.service.EnviarNotificacionPerfilService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarPerfilCreadoUseCaseTest {
    @Mock
    EnviarNotificacionPerfilService enviarNotificacionPerfilService;

    @Test
    void notificarPerfilCreado(){
        //Arrange
        IdPerfil idPerfil = IdPerfil.of("yyyyy");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("xxxxx");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("www.google.com/images/2343");
        InfoContacto infoContacto = new InfoContacto("Marlondvalencia@gmail.com");
        //Act
        var event = new PerfilCreado(idHojaDeVida,fotoDePerfil,infoContacto);
        event.setAggregateRootId(idPerfil.value());
        var useCase = new NotificarPerfilCreadoUseCase();
        when(enviarNotificacionPerfilService.sendMessage(
                "gestion@perfilprofesional.com","Su perfil creado satisfactoriamente", idPerfil
        )).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(enviarNotificacionPerfilService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();
        //Asserts
        verify(enviarNotificacionPerfilService).sendMessage(
                "gestion@perfilprofesional.com",
                "Su perfil creado satisfactoriamente",
                idPerfil);
    }
}
