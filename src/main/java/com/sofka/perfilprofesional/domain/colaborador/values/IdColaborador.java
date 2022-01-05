package com.sofka.perfilprofesional.domain.colaborador.values;

import co.com.sofka.domain.generic.Identity;

public class IdColaborador extends Identity {
    private IdColaborador(String value){
        super(value);
    }

    public IdColaborador(){

    }

    public static IdColaborador of(String value){
        return new IdColaborador(value);
    }
}
