package com.sofka.perfilprofesional.domain.gestioncertificacion.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.gestioncertificacion.Certificacion;

public class CrearGestionCertificacionCommand extends Command {
    public final IdHojaDeVida idHojaDeVida;
    public final Certificacion certificacion;

    public CrearGestionCertificacionCommand(IdHojaDeVida idHojaDeVida, Certificacion certificacion) {
        this.idHojaDeVida = idHojaDeVida;
        this.certificacion = certificacion;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }
}
