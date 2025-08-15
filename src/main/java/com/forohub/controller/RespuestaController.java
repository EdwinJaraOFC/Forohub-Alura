package com.forohub.controller;

import com.forohub.domain.respuestas.DatosCrearRespuesta;
import com.forohub.domain.respuestas.DatosRespuesta;
import com.forohub.domain.respuestas.Respuesta;
import com.forohub.domain.respuestas.RespuestaRepository;
import com.forohub.domain.topico.Topico;
import com.forohub.domain.topico.TopicoRepository;
import com.forohub.domain.usuario.Usuario;
import com.forohub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/respuestas")
@RequiredArgsConstructor
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;
    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity crearRespuesta(@RequestBody @Valid DatosCrearRespuesta datos) {
        Topico topico = topicoRepository.findById(datos.topicoId())
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        Usuario autor = usuarioRepository.findById(datos.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Respuesta respuesta = Respuesta.builder()
                .mensaje(datos.mensaje())
                .fechaCreacion(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS) )
                .topico(topico)
                .autor(autor)
                .build();

        respuestaRepository.save(respuesta);


        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Page<DatosRespuesta>> mostrarRespuestas(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<DatosRespuesta> pagina = respuestaRepository.findAll(pageable)
                .map(DatosRespuesta::desdeEntidad);

        return ResponseEntity.ok(pagina);
    }

    @DeleteMapping("/eliminarRespuesta/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));

        respuestaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
