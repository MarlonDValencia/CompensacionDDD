package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.perfil.commands.CrearPerfilCommand;
import com.sofka.perfilprofesional.domain.perfil.events.PerfilCreado;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearPerfilUseCaseTest {
    @Test
    public void crearPerfil(){
        //Arrange
        IdPerfil idPerfil = IdPerfil.of("xxxxx");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("zzzzz");
        InfoContacto infoContacto = new InfoContacto("Marlondvalencia@gmail.com");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("www.google.com/image/13932");
        //Act
        var command = new CrearPerfilCommand(
                idPerfil,
                idHojaDeVida,
                infoContacto,
                fotoDePerfil
        );
        var useCase = new CrearPerfilUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        PerfilCreado event = (PerfilCreado)events.getDomainEvents().get(0);
        //Asserts
        Assertions.assertEquals( "xxxxx", event.aggregateRootId());
        Assertions.assertEquals( "www.google.com/image/13932", event.getFotoDePerfil().value());
    }

@Test
    public void crearPerfilFailsBecauseOfContactInfo(){
        //Arrange
        IdPerfil idPerfil = IdPerfil.of("xxxxx");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("zzzzz");
        InfoContacto infoContacto = new InfoContacto("UnCorreoExtremadamenteLargoQueHaceQueLaPruebaFalle@gmail.com");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("www.google.com/image/13932");
        //Act
        var command = new CrearPerfilCommand(
                idPerfil,
                idHojaDeVida,
                infoContacto,
                fotoDePerfil
        );
        var useCase = new CrearPerfilUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        PerfilCreado event = (PerfilCreado)events.getDomainEvents().get(0);
        //Asserts
        Assertions.assertEquals( "xxxxx", event.aggregateRootId());
        Assertions.assertEquals( "www.google.com/image/13932", event.getFotoDePerfil().value());
    }
}
