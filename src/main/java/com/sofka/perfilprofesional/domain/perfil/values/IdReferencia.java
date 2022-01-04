package com.sofka.perfilprofesional.domain.perfil.values;

import co.com.sofka.domain.generic.Identity;

public class IdReferencia extends Identity {
    private IdReferencia(String value){
        super(value);
    }

    public IdReferencia(){
    }

    public static IdReferencia of(String value){
        return new IdReferencia(value);
    }
}
