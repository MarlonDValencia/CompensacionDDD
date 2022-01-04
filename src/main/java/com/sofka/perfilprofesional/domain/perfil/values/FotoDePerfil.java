package com.sofka.perfilprofesional.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FotoDePerfil implements ValueObject<String> {
    private final String linkDeLaImagen;

    public FotoDePerfil(String linkDeLaImagen){
        this.linkDeLaImagen = Objects.requireNonNull(linkDeLaImagen, "El link no puede ser nulo");
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        FotoDePerfil foto = (FotoDePerfil) o;
        return Objects.equals(linkDeLaImagen,foto.linkDeLaImagen);
    }

    @Override
    public int hashCode(){
        return Objects.hash(linkDeLaImagen);
    }

    @Override
    public String value(){
        return linkDeLaImagen;
    }
}