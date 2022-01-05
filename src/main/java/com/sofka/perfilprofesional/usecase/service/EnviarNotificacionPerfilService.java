package com.sofka.perfilprofesional.usecase.service;

import com.sofka.perfilprofesional.domain.experiencia.values.IdExperiencia;
import com.sofka.perfilprofesional.domain.perfil.values.IdPerfil;

public interface EnviarNotificacionPerfilService {
    boolean sendMessage(String Correo, String CuerpoDelCorreo, IdPerfil idPerfil);
}
