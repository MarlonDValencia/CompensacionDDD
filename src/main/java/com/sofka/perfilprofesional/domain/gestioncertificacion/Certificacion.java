package com.sofka.perfilprofesional.domain.gestioncertificacion;

import co.com.sofka.domain.generic.Entity;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.domain.gestioncertificacion.values.IdCertificacion;
import com.sofka.perfilprofesional.domain.gestioncertificacion.values.NombreCertificacion;

import java.util.Objects;

public class Certificacion extends Entity<IdCertificacion> {
    private NombreCertificacion nombreCertificacion;
    private final Institucion institucion;
    private final Periodo periodo;

    public Certificacion(IdCertificacion idCertificacion, NombreCertificacion nombreCertificacion, Institucion institucion, Periodo periodo) {
        super(idCertificacion);
        this.nombreCertificacion = Objects.requireNonNull(nombreCertificacion);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public void modificarNombreCertificacion(String nombre){
        Objects.requireNonNull(nombre);
        this.nombreCertificacion = this.nombreCertificacion.modificarNombreCertificacion(nombre);
    }

    public NombreCertificacion nombreCertificacion() {
        return nombreCertificacion;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }
}
