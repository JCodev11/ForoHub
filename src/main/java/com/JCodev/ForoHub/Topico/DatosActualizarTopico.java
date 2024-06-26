package com.JCodev.ForoHub.Topico;

import com.JCodev.ForoHub.Estado.Estado;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull long id,
        String titulo,
        String mensaje,
        Estado estado,
        String respuestas
) {

}
