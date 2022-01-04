package com.sofka.perfilprofesional.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.Identity;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;

public class IdGestionEducacion extends Identity {
    private IdGestionEducacion(String value){
        super(value);
    }

    public IdGestionEducacion(){

    }

    public static IdGestionEducacion of(String value){
        return new IdGestionEducacion(value);
    }
}
