package com.sofka.perfilprofesional.domain.experiencia.values;

import co.com.sofka.domain.generic.Identity;

public class IdExperienciaLaboral extends Identity {
    private IdExperienciaLaboral(String value){
        super(value);
    }

    public IdExperienciaLaboral(){
    }

    public static IdExperienciaLaboral of(String value){
        return new IdExperienciaLaboral(value);
    }
}
