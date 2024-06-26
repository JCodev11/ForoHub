package com.JCodev.ForoHub.Controller;

import com.JCodev.ForoHub.Topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRegistroTopico> crearTopico(@RequestBody @Valid DatosRegistroTopico datosregistroTopico) {
        topicoRepository.save(new Topico(datosregistroTopico));
        System.out.println("Topico registrado exitosamente"+datosregistroTopico);
        return ResponseEntity.ok(datosregistroTopico);
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size=20, page=0 , sort = "autor") Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    @PutMapping
    @Transactional
    public void ActualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
topico.ActualizarTopico(datosActualizarTopico);
    }
@DeleteMapping("/{id}")
@Transactional
    public void eliminarTopico(@PathVariable long id){
    Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}
