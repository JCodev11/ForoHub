package com.JCodev.ForoHub.Topico;

import com.JCodev.ForoHub.Curso.Curso;
import com.JCodev.ForoHub.Estado.Estado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
//        long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Valid
        Estado estado,
        @NotBlank
        String autor,
        @NotNull
                @Valid
        Curso curso,
        @NotBlank
        String respuestas
) {
    @Override
    public String toString() {
        return "DatosRegistroTopico{" +
                "titulo='" + titulo + '\'' + "\n" +
                "mensaje='" + mensaje + '\'' + "\n" +
                "estado=" + estado + "\n" +
                "autor='" + autor + '\'' + "\n" +
                "curso='" + curso + '\'' + "\n" +
                "respuestas='" + respuestas + '\'' + "\n" +
                '}';
    }

}
