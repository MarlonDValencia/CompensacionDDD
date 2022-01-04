package com.sofka.perfilprofesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Entity;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.*;

import java.util.Objects;

public class Educacion extends Entity<IdEducacion> {
    private final TipoEducacion tipoEducacion;
    private TipoEstudio tipoEstudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public Educacion(IdEducacion idEducacion, TipoEducacion tipoEducacion, TipoEstudio tipoEstudio, Institucion institucion, Periodo periodo) {
        super(idEducacion);
        this.tipoEducacion = Objects.requireNonNull(tipoEducacion);
        this.tipoEstudio = Objects.requireNonNull(tipoEstudio);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public void modificarTipoEstudio(String tipoEstudio){
        Objects.requireNonNull(tipoEstudio);
        this.tipoEstudio = this.tipoEstudio.modificarTipoEstudio(tipoEstudio);
    }

    public TipoEducacion tipoEducacion() {
        return tipoEducacion;
    }

    public TipoEstudio tipoEstudio() {
        return tipoEstudio;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo  periodo() {
        return periodo;
    }
}
