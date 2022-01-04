package com.sofka.perfilprofesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.*;

import java.util.Objects;

public class GestionEducacionChange extends EventChange {
    public GestionEducacionChange(GestionEducacion gestionEducacion){
        apply((GestionEducacionCreada event) -> {
            gestionEducacion.idHojaDeVida = Objects.requireNonNull(event.getIdHojaDeVida());
        });

        apply((NuevaEducacionAgregada event)-> {
            gestionEducacion.educaciones.add(new Educacion(
                    event.getIdEducacion(),
                    event.getTipoEducacion(),
                    event.getTipoEstudio(),
                    event.getInstitucion(),
                    event.getPeriodo()
            ));
        });

        apply((EducacionEliminada event) -> {
            var id = event.getIdEducacion();
            gestionEducacion.educaciones.removeIf(educacion -> educacion.identity().equals(id));
        });
    }
}
