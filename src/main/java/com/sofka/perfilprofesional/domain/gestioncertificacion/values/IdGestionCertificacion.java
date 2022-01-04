package com.sofka.perfilprofesional.domain.gestioncertificacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdGestionCertificacion extends Identity {
    private IdGestionCertificacion(String value) {
        super(value);
    }

    public IdGestionCertificacion() {
    }

    public static IdGestionCertificacion of(String value) {
        return new IdGestionCertificacion(value);
    }
}
