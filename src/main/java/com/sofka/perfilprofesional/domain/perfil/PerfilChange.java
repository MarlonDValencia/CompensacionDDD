package com.sofka.perfilprofesional.domain.perfil;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.perfil.events.NuevaReferenciaAgregada;
import com.sofka.perfilprofesional.domain.perfil.events.PerfilCreado;
import com.sofka.perfilprofesional.domain.perfil.events.ReferenciaEliminada;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;

import java.util.Set;

public class PerfilChange extends EventChange {
    public PerfilChange(Perfil perfil){
        apply((PerfilCreado event) -> {
            perfil.idHojaDeVida = event.getIdHojaDeVida();
            perfil.fotoDePerfil = event.getFotoDePerfil();
            perfil.infoContacto = event.getInfoContacto();
        });

        apply((NuevaReferenciaAgregada event)->{
            perfil.referencias.add(new Referencia(
                    event.getIdReferencia(),
                    event.getInfoContacto(),
                    event.getNombreCompleto()
            ));
        });

        apply((ReferenciaEliminada event)->{
            var IdReferencia = event.getIdReferencia();
            perfil.referencias.removeIf(item -> item.identity().equals(IdReferencia));
        });
    }
}
