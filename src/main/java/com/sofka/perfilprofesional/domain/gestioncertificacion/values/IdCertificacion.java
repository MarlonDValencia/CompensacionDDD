package com.sofka.perfilprofesional.domain.gestioncertificacion.values;

import co.com.sofka.domain.generic.Identity;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;

public class IdCertificacion extends Identity {
    private IdCertificacion(String value) {
        super(value);
    }

    public IdCertificacion() {
    }

    public static IdCertificacion of(String value) {
        return new IdCertificacion(value);
    }
}
