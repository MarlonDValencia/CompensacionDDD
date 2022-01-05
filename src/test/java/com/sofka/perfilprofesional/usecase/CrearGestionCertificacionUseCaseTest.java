package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.perfilprofesional.domain.colaborador.events.ColaboradorCreado;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.domain.gestioncertificacion.Certificacion;
import com.sofka.perfilprofesional.domain.gestioncertificacion.commands.CrearGestionCertificacionCommand;
import com.sofka.perfilprofesional.domain.gestioncertificacion.events.GestionCertificacionCreada;
import com.sofka.perfilprofesional.domain.gestioncertificacion.values.IdCertificacion;
import com.sofka.perfilprofesional.domain.gestioncertificacion.values.IdGestionCertificacion;
import com.sofka.perfilprofesional.domain.gestioncertificacion.values.NombreCertificacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;


class CrearGestionCertificacionUseCaseTest {
    @Test
    public void crearGestionCertificacion(){
        //Arrange
        IdGestionCertificacion idGestionCertificacion = IdGestionCertificacion.of("xxxxx");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("zzzzz");
        IdCertificacion idCertificacion = IdCertificacion.of("yyyyy");
        NombreCertificacion nombreCertificacion = new NombreCertificacion("Platzi Js Course");
        Institucion institucion = new Institucion("Platzi");
        Date date1 = new Date();
        Date date2 = new Date(2060,7,1);
        Periodo periodo = new Periodo(date1,date2);
        Certificacion certificacion = new Certificacion(idCertificacion,
                nombreCertificacion,
                institucion,
                periodo);
        //Act
        var command = new CrearGestionCertificacionCommand(idGestionCertificacion,
                idHojaDeVida,
                certificacion);
        var useCase = new CrearGestionCertificacionUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        GestionCertificacionCreada event = (GestionCertificacionCreada)events.getDomainEvents().get(0);
        //Asserts
        Assertions.assertEquals( "xxxxx", event.aggregateRootId());
        Assertions.assertEquals( "Platzi Js Course", event.getCertificacion().nombreCertificacion().value());
    }
}
