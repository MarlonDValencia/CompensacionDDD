package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.perfilprofesional.domain.colaborador.commands.CrearColaboradorCommand;
import com.sofka.perfilprofesional.domain.colaborador.events.ColaboradorCreado;
import com.sofka.perfilprofesional.domain.colaborador.values.*;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

class CrearColaboradorUseCaseTest {
    @Test
    public void crearColaborador() {
        //Arrange
        IdColaborador idColaborador = IdColaborador.of("xxxxx");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("yyyyy");
        FechaNacimiento fechaNacimiento = new FechaNacimiento(new Date(1999, Calendar.AUGUST,1));
        NombreCompleto nombreCompleto = new NombreCompleto("Marlon", "Valencia");
        Cedula cedula = new Cedula("1193420015");
        Genero genero = new Genero("Masculino");
        Area area = new Area("Area");
        //Act
        var command = new CrearColaboradorCommand(idColaborador
                , idHojaDeVida,
                fechaNacimiento,
                nombreCompleto,
                cedula,
                genero,
                area);
        var useCase = new CrearColaboradorUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        //Assert
        ColaboradorCreado event = (ColaboradorCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals( "xxxxx", event.aggregateRootId());
        Assertions.assertEquals( "yyyyy", event.getIdHojaDeVida().value());
    }
}
