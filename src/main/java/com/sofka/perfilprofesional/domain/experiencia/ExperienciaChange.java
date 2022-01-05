package com.sofka.perfilprofesional.domain.experiencia;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaCreada;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaLaboralAgregada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.EducacionEliminada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.NuevaEducacionAgregada;

import java.util.HashSet;
import java.util.Objects;

public class ExperienciaChange  extends EventChange {
    public ExperienciaChange(Experiencia experiencia){
        apply((ExperienciaCreada event) -> {
            experiencia.experienciaLaboral = new HashSet<>();
            experiencia.idHojaDeVida = Objects.requireNonNull(event.getIdHojaDeVida());
        });

        apply((ExperienciaLaboralAgregada event)-> {
            experiencia.experienciaLaboral.add(new ExperienciaLaboral(
                    event.getIdExperienciaLaboral(),
                    event.getInstitucion(),
                    event.getPeriodo(),
                    event.getConocimientosAdquiridos()
            ));
        });

        apply((EducacionEliminada event) -> {
            var id = event.getIdEducacion();
            experiencia.experienciaLaboral.removeIf(experienciaLaboral -> experienciaLaboral.identity().equals(id));
        });
    }
}
