package com.sofka.perfilprofesional.domain.gestioncertificacion.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.gestioncertificacion.Certificacion;
import com.sofka.perfilprofesional.domain.gestioncertificacion.values.IdGestionCertificacion;

import java.util.Objects;

public class CrearGestionCertificacionCommand extends Command {
    private final IdGestionCertificacion idGestionCertificacion;
    public final IdHojaDeVida idHojaDeVida;
    public final Certificacion certificacion;

    public CrearGestionCertificacionCommand(IdGestionCertificacion idGestionCertificacion,IdHojaDeVida idHojaDeVida, Certificacion certificacion) {
        this.idGestionCertificacion = Objects.requireNonNull(idGestionCertificacion);
        this.idHojaDeVida = Objects.requireNonNull(idHojaDeVida);
        this.certificacion = Objects.requireNonNull(certificacion);
    }

    public IdGestionCertificacion getIdGestionCertificacion() {
        return idGestionCertificacion;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }
}
