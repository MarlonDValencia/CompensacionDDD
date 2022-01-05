package com.sofka.perfilprofesional.domain.perfil;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.perfil.events.NuevaReferenciaAgregada;
import com.sofka.perfilprofesional.domain.perfil.events.PerfilCreado;
import com.sofka.perfilprofesional.domain.perfil.events.ReferenciaEliminada;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PerfilChange extends EventChange {
    public PerfilChange(Perfil perfil){
        apply((PerfilCreado event) -> {
            perfil.referencias = new HashSet<>();
            perfil.idHojaDeVida = Objects.requireNonNull(event.getIdHojaDeVida());
            perfil.fotoDePerfil = Objects.requireNonNull(event.getFotoDePerfil());
            perfil.infoContacto = Objects.requireNonNull(event.getInfoContacto());
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
            perfil.referencias.removeIf(referencia -> referencia.identity().equals(IdReferencia));
        });
    }
}
