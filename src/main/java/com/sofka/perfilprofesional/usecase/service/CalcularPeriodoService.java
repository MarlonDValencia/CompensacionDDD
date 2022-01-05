package com.sofka.perfilprofesional.usecase.service;

import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.domain.generics.Periodo;

public interface CalcularPeriodoService {
    Double calcularTiempo(IdExperiencia idExperiencia, Periodo periodo);
}
