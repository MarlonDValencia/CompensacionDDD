package com.sofka.perfilprofesional.domain.generics;

import co.com.sofka.domain.generic.Identity;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;

public class IdHojaDeVida extends Identity {
    private IdHojaDeVida(String value){
        super(value);
    }

    public IdHojaDeVida(){

    }

    public static IdHojaDeVida of(String value){
        return new IdHojaDeVida(value);
    }
}
