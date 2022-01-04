package com.sofka.perfilprofesional.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoEstudio implements ValueObject<String> {
    private final String tipoDeEstudio;

    public TipoEstudio(String tipoDeEstudio) {
        this.tipoDeEstudio = Objects.requireNonNull(tipoDeEstudio, "El  tipo de estudio no puede ser nulo");
    }

    public TipoEstudio modificarTipoEstudio(String tipoEstudio){
        return new TipoEstudio(tipoEstudio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TipoEstudio that = (TipoEstudio) o;
        return tipoDeEstudio.equals(that.tipoDeEstudio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDeEstudio);
    }

    @Override
    public String value(){
        return tipoDeEstudio;
    }

}
