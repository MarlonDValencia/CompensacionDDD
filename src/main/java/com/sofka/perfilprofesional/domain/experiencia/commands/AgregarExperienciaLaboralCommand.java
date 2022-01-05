package com.sofka.perfilprofesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.experiencia.values.ConocimientosAdquiridos;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;

public class AgregarExperienciaLaboralCommand extends Command {
    private final IdExperiencia idExperiencia;
    private final IdExperienciaLaboral idExperienciaLaboral;
    private final Institucion institucion;
    private final Periodo periodo;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public AgregarExperienciaLaboralCommand( IdExperiencia idExperiencia,IdExperienciaLaboral idExperienciaLaboral, Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        this.idExperiencia = idExperiencia;
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public IdExperiencia getIdExperiencia() {
        return idExperiencia;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
