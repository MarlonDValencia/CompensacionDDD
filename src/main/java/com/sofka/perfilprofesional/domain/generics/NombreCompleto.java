package com.sofka.perfilprofesional.domain.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject<NombreCompleto.Properties> {
    private String nombre;
    private String apellido;

    public NombreCompleto(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.apellido = Objects.requireNonNull(apellido, "El apellido no puede ser nulo");
    }

    public NombreCompleto actualizarNombreCompleto(String nombre, String apellido) {
        return new NombreCompleto(nombre, apellido);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreCompleto nombreCompleto = (NombreCompleto) o;
        return Objects.equals(nombre, nombreCompleto.nombre) && Objects.equals(apellido, nombreCompleto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }

    public interface Properties {
        String nombre();

        String apellido();
    }
}
