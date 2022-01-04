package com.sofka.perfilprofesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEstudio;

public class AgregarEducacionCommand extends Command {
    private final IdEducacion idEducacion;
    private final TipoEducacion tipoEducacion;
    private final TipoEstudio tipoEstudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarEducacionCommand(IdEducacion idEducacion, TipoEducacion tipoEducacion, TipoEstudio tipoEstudio, Institucion institucion, Periodo periodo) {
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
