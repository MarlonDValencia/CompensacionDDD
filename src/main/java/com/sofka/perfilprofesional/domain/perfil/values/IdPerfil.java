package com.sofka.perfilprofesional.domain.perfil.values;

import co.com.sofka.domain.generic.Identity;

public class IdPerfil extends Identity {
    private IdPerfil(String value){
        super(value);
    }

    public IdPerfil(){

    }

    public static IdPerfil of(String value){
        return new IdPerfil(value);
    }
}
