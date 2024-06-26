package com.JCodev.ForoHub.Topico;

import com.JCodev.ForoHub.Curso.Curso;
import com.JCodev.ForoHub.Estado.Estado;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autor,
        String curso
) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado().toString(),
                topico.getAutor(),
                topico.getCurso().toString()
        );
    }
}
