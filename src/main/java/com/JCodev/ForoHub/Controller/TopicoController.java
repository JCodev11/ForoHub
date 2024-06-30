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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

@PostMapping
public ResponseEntity<DatosRegistroTopico> crearTopico(@RequestBody @Valid DatosRegistroTopico datosregistroTopico, UriComponentsBuilder uriComponentsBuilder) {
    Topico topico = new Topico(datosregistroTopico);
    topicoRepository.save(topico);
    System.out.println("Topico registrado exitosamente: " + datosregistroTopico);

    // Construye la URI usando el ID del Topico guardado
    URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
    return ResponseEntity.created(url).body(datosregistroTopico);
}


@GetMapping("/{id}")
public ResponseEntity<DatosListadoTopico> obtenerTopico(@PathVariable long id) {
    Topico topico = topicoRepository.findById(id).orElseThrow();
    return ResponseEntity.ok(new DatosListadoTopico(topico));
}
@GetMapping
public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size=20, page=0, sort = "autor") Pageable paginacion) {
    Page<DatosListadoTopico> topicos = topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    return ResponseEntity.ok(topicos);
}

    @PutMapping
    @Transactional
    public ResponseEntity ActualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
topico.ActualizarTopico(datosActualizarTopico);
return ResponseEntity.ok(new DatosListadoTopico(topico));
    }
@DeleteMapping("/{id}")
@Transactional
    public ResponseEntity eliminarTopico(@PathVariable long id){
    Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}
