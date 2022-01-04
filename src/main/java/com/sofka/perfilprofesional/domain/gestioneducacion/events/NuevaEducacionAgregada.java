package com.sofka.perfilprofesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEstudio;

public class NuevaEducacionAgregada extends DomainEvent {
    private final IdEducacion idEducacion;
    private final TipoEducacion tipoEducacion;
    private final TipoEstudio tipoEstudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public NuevaEducacionAgregada(IdEducacion idEducacion,TipoEducacion tipoEducacion, TipoEstudio tipoEstudio, Institucion institucion, Periodo periodo) {
        super("sofka.perfilprofesional.nuevaeducacioncreada");
        this.idEducacion = idEducacion;
        this.tipoEducacion = tipoEducacion;
        this.tipoEstudio = tipoEstudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }


    public IdEducacion getIdEducacion() {
        return idEducacion;
    }

    public TipoEducacion getTipoEducacion() {
        return tipoEducacion;
    }

    public TipoEstudio getTipoEstudio() {
        return tipoEstudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
