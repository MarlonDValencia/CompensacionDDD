package com.sofka.perfilprofesional.domain.experiencia.values;

import co.com.sofka.domain.generic.Identity;

public class IdExperiencia extends Identity {
    private IdExperiencia(String value){
        super(value);
    }

    public IdExperiencia(){
    }

    public static IdExperiencia of(String value){
        return new IdExperiencia(value);
    }
}
