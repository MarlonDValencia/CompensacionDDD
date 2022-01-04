package com.sofka.perfilprofesional.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.perfilprofesional.domain.generics.IdHojaDeVida;
import com.sofka.perfilprofesional.domain.generics.InfoContacto;
import com.sofka.perfilprofesional.domain.generics.NombreCompleto;
import com.sofka.perfilprofesional.domain.perfil.events.NuevaReferenciaAgregada;
import com.sofka.perfilprofesional.domain.perfil.events.PerfilCreado;
import com.sofka.perfilprofesional.domain.perfil.events.ReferenciaEliminada;
import com.sofka.perfilprofesional.domain.perfil.values.FotoDePerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;
import com.sofka.perfilprofesional.domain.perfil.values.IdReferencia;

import java.util.List;
import java.util.Set;

public class Perfil extends AggregateEvent<IdPerfil>{
    protected IdHojaDeVida idHojaDeVida;
    protected InfoContacto infoContacto;
    protected FotoDePerfil fotoDePerfil;
    protected Set<Referencia> referencias;

    public Perfil(IdPerfil idPerfil, IdHojaDeVida idHojaDeVida,FotoDePerfil fotoDePerfil,InfoContacto infoContacto){
        super(idPerfil);
        subscribe(new PerfilChange(this));
        appendChange(new PerfilCreado(idHojaDeVida,fotoDePerfil,infoContacto)).apply();
    }

    private Perfil(IdPerfil idPerfil){
        super(idPerfil);
        subscribe(new PerfilChange(this));
    }

    public static Perfil from(IdPerfil idPerfil, List<DomainEvent> events){
        var perfil = new Perfil(idPerfil);
        events.forEach(perfil::applyEvent);
        return perfil;
    }

    public void agregarNuevaReferencia(IdReferencia idReferencia,InfoContacto infoContacto,NombreCompleto nombreCompleto){
        var id = new IdReferencia();
        appendChange(new NuevaReferenciaAgregada(idReferencia,infoContacto,nombreCompleto)).apply();
    }

    public void eliminarReferencia(IdReferencia idReferencia){
        appendChange(new ReferenciaEliminada(idReferencia)).apply();
    }

    public IdHojaDeVida idHojaDeVida() {
        return idHojaDeVida;
    }

    public InfoContacto infoContacto() {
        return infoContacto;
    }

    public FotoDePerfil fotoDePerfil() {
        return fotoDePerfil;
    }

    public Set<Referencia> referencias() {
        return referencias;
    }
}
