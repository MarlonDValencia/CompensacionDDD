package com.sofka.perfilprofesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;

public class CrearPerfilCommand extends Command {
    private final IdHojaDeVida idHojaDeVida;
    private final InfoContacto infoContacto;
    private final FotoDePerfil fotoDePerfil;

    public CrearPerfilCommand(IdHojaDeVida idHojaDeVida, InfoContacto infoContacto, FotoDePerfil fotoDePerfil) {
        this.idHojaDeVida = idHojaDeVida;
        this.infoContacto = infoContacto;
        this.fotoDePerfil = fotoDePerfil;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public InfoContacto getInfoContacto() {
        return infoContacto;
    }

    public FotoDePerfil getFotoDePerfil() {
        return fotoDePerfil;
    }
}
