package com.sofka.perfilprofesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.Institucion;
import com.sofka.perfilprofesional.domain.generics.Periodo;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.EducacionEliminada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.sofka.perfilprofesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.IdGestionEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEducacion;
import com.sofka.perfilprofesional.domain.gestioneducacion.values.TipoEstudio;
import com.sofka.perfilprofesional.domain.perfil.Perfil;

import java.util.List;
import java.util.Set;

public class GestionEducacion  extends AggregateEvent<IdGestionEducacion> {
    protected IdHojaDeVida idHojaDeVida;
    protected Set<Educacion> educaciones;
    public GestionEducacion(IdGestionEducacion idGestionEducacion, IdHojaDeVida idHojaDeVida, Set<Educacion> educaciones){
        super(idGestionEducacion);
        subscribe(new GestionEducacionChange(this));
        appendChange(new GestionEducacionCreada(idHojaDeVida)).apply();
    }

    private GestionEducacion(IdGestionEducacion idGestionEducacion){
        super(idGestionEducacion);
        subscribe(new GestionEducacionChange(this));
    }

    public static GestionEducacion from(IdGestionEducacion idGestionEducacion, List<DomainEvent> events){
        var gestionEducacion = new GestionEducacion(idGestionEducacion);
        events.forEach(gestionEducacion::applyEvent);
        return gestionEducacion;
    }

    public void agregarNuevaEducacion(TipoEducacion tipoEducacion,TipoEstudio tipoEstudio,Institucion institucion,Periodo periodo){
        var id = new IdEducacion();
        appendChange(new NuevaEducacionAgregada(id,tipoEducacion,tipoEstudio,institucion,periodo)).apply();
    }

    public void eliminarEducacion(IdEducacion idEducacion){
        appendChange(new EducacionEliminada(idEducacion)).apply();
    }

    public IdHojaDeVida idHojaDeVida() {
        return idHojaDeVida;
    }

    public Set<Educacion> educaciones() {
        return educaciones;
    }
}
