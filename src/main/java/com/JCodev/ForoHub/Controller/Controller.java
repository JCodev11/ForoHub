package com.JCodev.ForoHub.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ConsultarTopico")

public class Controller {

    @GetMapping
    //Crear metodo que retorne un String
public String ejecutar() {
return "Bienvenido a ForoHub!";
}

}
