package com.sofka.perfilprofesional.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.perfilprofesional.domain.experiencia.ExperienciaLaboral;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaCreada;
import com.sofka.perfilprofesional.domain.experiencia.values.ConocimientosAdquiridos;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.usecase.experiencia.NotificarExperienciaCreadaUseCase;
import com.sofka.perfilprofesional.usecase.service.EnviarNotificacionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
class NotificarExperienciaCreadaUseCaseTest {
    @Mock
    EnviarNotificacionService enviarNotificacionService;

    @Test
    void notificarExperienciaCreada(){
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
        var useCase = new NotificarExperienciaCreadaUseCase();
        when(enviarNotificacionService.sendMessage(
                "gestion@perfilprofesional.com","Su experiencia ha sido aceptada y creada exitosamente!", idExperiencia
        )).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(enviarNotificacionService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idExperiencia.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        //Assert
        verify(enviarNotificacionService).sendMessage(
                "gestion@perfilprofesional.com",
                "Su experiencia ha sido aceptada y creada exitosamente!",
                idExperiencia);
    }
}
