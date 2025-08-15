package com.forohub.domain.respuestas;

import com.forohub.domain.topico.DatosUsuario;


public record DatosRespuesta(
        Long id,
        String mensaje,
        DatosUsuario autor
) {
    public static DatosRespuesta desdeEntidad(Respuesta respuesta) {
        return new DatosRespuesta(
                respuesta.getId(),
                respuesta.getMensaje(),
                DatosUsuario.desdeEntidad(respuesta.getAutor())
        );
    }
}


