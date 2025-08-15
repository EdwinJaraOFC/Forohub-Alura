package com.forohub.domain.topico;

import com.forohub.domain.usuario.Usuario;

public record DatosUsuario(
        String nombre,
        String apellido
) {
    public static DatosUsuario desdeEntidad(Usuario usuario) {
        return new DatosUsuario(usuario.getNombre(), usuario.getApellido());
    }
}

