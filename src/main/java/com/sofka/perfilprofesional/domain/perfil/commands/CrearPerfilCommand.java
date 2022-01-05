package com.sofka.perfilprofesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;

import java.util.Objects;

public class CrearPerfilCommand extends Command {
    private final IdPerfil idPerfil;
    private final IdHojaDeVida idHojaDeVida;
    private final InfoContacto infoContacto;
    private final FotoDePerfil fotoDePerfil;

    public CrearPerfilCommand(IdPerfil idPerfil,IdHojaDeVida idHojaDeVida, InfoContacto infoContacto, FotoDePerfil fotoDePerfil) {
        this.idPerfil = Objects.requireNonNull(idPerfil);
        this.idHojaDeVida = Objects.requireNonNull(idHojaDeVida);
        this.infoContacto = Objects.requireNonNull(infoContacto);
        this.fotoDePerfil = Objects.requireNonNull(fotoDePerfil);
    }

    public IdPerfil getIdPerfil() {
        return idPerfil;
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
