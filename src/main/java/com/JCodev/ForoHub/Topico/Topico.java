package com.JCodev.ForoHub.Topico;

import com.JCodev.ForoHub.Curso.Curso;
import com.JCodev.ForoHub.Estado.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private String respuestas;



    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }
    public Topico(DatosRegistroTopico registroTopico) {
        this.titulo = registroTopico.titulo();
        this.mensaje = registroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = registroTopico.estado();
        this.autor = registroTopico.autor();
        this.curso = registroTopico.curso();
        this.respuestas = registroTopico.respuestas();
    }
    public void ActualizarTopico(DatosActualizarTopico datosActualizarTopico) {
       if (datosActualizarTopico.titulo() != null){
           this.titulo = datosActualizarTopico.titulo();
       }
       if (datosActualizarTopico.mensaje() != null){
        this.mensaje = datosActualizarTopico.mensaje();
    }
       if (datosActualizarTopico.estado() != null){
        this.estado = datosActualizarTopico.estado();
    }
       if (datosActualizarTopico.respuestas() != null){
        this.respuestas = datosActualizarTopico.respuestas();
    }
    }

}
