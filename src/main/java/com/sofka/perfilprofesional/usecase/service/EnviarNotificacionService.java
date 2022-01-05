package com.sofka.perfilprofesional.usecase.service;

import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;

public interface EnviarNotificacionService {
    boolean sendMessage(String Correo, String CuerpoDelCorreo, IdExperiencia idExperiencia);
}
