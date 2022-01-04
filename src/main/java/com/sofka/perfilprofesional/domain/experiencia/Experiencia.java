package com.sofka.perfilprofesional.domain.experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaCreada;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaLaboralAgregada;
import com.sofka.perfilprofesional.domain.experiencia.events.ExperienciaLaboralEliminada;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;

import java.util.List;
import java.util.Set;

public class Experiencia extends AggregateEvent<IdExperiencia> {
    protected IdHojaDeVida idHojaDeVida;
    protected Set<ExperienciaLaboral> experienciaLaboral;
    public Experiencia(IdExperiencia idExperiencia, IdHojaDeVida idHojaDeVida, Set<ExperienciaLaboral> experienciaLaboral){
        super(idExperiencia);
        subscribe(new ExperienciaChange(this));
        appendChange(new ExperienciaCreada(idHojaDeVida)).apply();
    }

    private Experiencia(IdExperiencia idExperiencia){
        super(idExperiencia);
        subscribe(new ExperienciaChange(this));
    }

    public static Experiencia from(IdExperiencia idExperiencia, List<DomainEvent> events){
        var experiencia = new Experiencia(idExperiencia);
        events.forEach(experiencia::applyEvent);
        return experiencia;
    }

    public void agregarExperienciaLaboral(){
        var id = new IdEducacion();
        appendChange(new ExperienciaLaboralAgregada()).apply();
    }

    public void eliminarExperienciaLaboral(IdExperienciaLaboral idExperienciaLaboral){
        appendChange(new ExperienciaLaboralEliminada(idExperienciaLaboral)).apply();
    }

    public IdHojaDeVida idHojaDeVida() {
        return idHojaDeVida;
    }

    public Set<ExperienciaLaboral> experienciaLaboral() {
        return experienciaLaboral;
    }
}
