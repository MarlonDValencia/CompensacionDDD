package com.sofka.perfilprofesional.domain.perfil;

import co.com.sofka.domain.generic.Entity;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;
import com.sofka.perfilprofesional.domain.perfil.values.IdReferencia;

import java.util.Objects;

public class Referencia extends Entity<IdReferencia> {

    private final InfoContacto infoContacto;
    private NombreCompleto nombreCompleto;
    public Referencia(IdReferencia idReferencia, InfoContacto infoContacto, NombreCompleto nombreCompleto) {
        super(idReferencia);
        this.infoContacto = Objects.requireNonNull(infoContacto);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public void actualizarNombreCompleto(String nombre, String apellido){
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(apellido);
        this.nombreCompleto = this.nombreCompleto.actualizarNombreCompleto(nombre,apellido);
    }

    public InfoContacto infoContacto() {
        return infoContacto;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }
}
