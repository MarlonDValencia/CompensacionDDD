package com.sofka.perfilprofesional.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdEducacion extends Identity {
    private IdEducacion(String value){
        super(value);
    }

    public IdEducacion(){
    }

    public static IdEducacion of(String value){
        return new IdEducacion(value);
    }
}
