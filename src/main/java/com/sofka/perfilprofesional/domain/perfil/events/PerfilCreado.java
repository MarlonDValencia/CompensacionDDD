package com.sofka.perfilprofesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;

public class PerfilCreado extends DomainEvent {
    private final IdHojaDeVida idHojaDeVida;
    private final InfoContacto infoContacto;
    private final FotoDePerfil fotoDePerfil;

    public PerfilCreado(IdHojaDeVida idHojaDeVida, FotoDePerfil fotoDePerfil,InfoContacto infoContacto) {
        super("sofka.perfilprofesional.perfilcreado");
        this.idHojaDeVida = idHojaDeVida;
        this.fotoDePerfil = fotoDePerfil;
        this.infoContacto = infoContacto;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public FotoDePerfil getFotoDePerfil() {
        return fotoDePerfil;
    }

    public InfoContacto getInfoContacto() {
        return infoContacto;
    }
}
