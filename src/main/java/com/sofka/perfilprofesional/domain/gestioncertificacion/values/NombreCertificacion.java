package com.sofka.perfilprofesional.domain.gestioncertificacion.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEstudio;

import java.util.Objects;

public class NombreCertificacion implements ValueObject<String> {
    private final String nombreCertificacion;

    public NombreCertificacion(String nombreCertificacion){
        this.nombreCertificacion = Objects.requireNonNull(nombreCertificacion, "El nombre de la certificacion no puede ser nula");
    }

    public NombreCertificacion modificarNombreCertificacion(String nombreCertificacion){
        return new NombreCertificacion(nombreCertificacion);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        NombreCertificacion certificacionNombre = (NombreCertificacion) o;
        return Objects.equals(nombreCertificacion,certificacionNombre.nombreCertificacion);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombreCertificacion);
    }

    @Override
    public String value(){
        return nombreCertificacion;
    }
}
