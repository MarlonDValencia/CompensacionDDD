package com.sofka.perfilprofesional.domain.experiencia;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaLaboralAgregada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.EducacionEliminada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.NuevaEducacionAgregada;

import java.util.Objects;

public class ExperienciaChange  extends EventChange {
    public ExperienciaChange(Experiencia experiencia){
        apply((GestionEducacionCreada event) -> {
            experiencia.idHojaDeVida = Objects.requireNonNull(event.getIdHojaDeVida());
        });

        apply((ExperienciaLaboralAgregada event)-> {
            experiencia.experienciaLaboral.add(new ExperienciaLaboral(

            ));
        });

        apply((EducacionEliminada event) -> {
            var id = event.getIdEducacion();
            experiencia.experienciaLaboral.removeIf(experienciaLaboral -> experienciaLaboral.identity().equals(id));
        });
    }
}
