package com.sofka.perfilprofesional.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Area  implements ValueObject<String> {
    private final String area;

    public Area(String area){
        this.area = Objects.requireNonNull(area, "El género no puede ser nulo");
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Area Area = (Area) o;
        return Objects.equals(area,Area.area);
    }

    @Override
    public int hashCode(){
        return Objects.hash(area);
    }

    @Override
    public String value(){
        return area;
    }
}
