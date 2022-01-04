package com.sofka.perfilprofesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.*;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEstudio;
import com.sofka.perfilprofesional.domain.perfil.Perfil;
import com.sofka.perfilprofesional.domain.perfil.Referencia;

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
