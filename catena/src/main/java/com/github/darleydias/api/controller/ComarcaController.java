package com.github.darleydias.api.controller;

import ch.qos.logback.core.net.server.Client;
import com.github.darleydias.domain.entity.Comarca;
import com.github.darleydias.domain.repository.Comarcas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/comarcas")
public class ComarcaController {
    private Comarcas comarcas; //DAO

    public ComarcaController(Comarcas comarcas) {
        this.comarcas = comarcas;
    }

    //    @RequestMapping(value="/hello/{nome}", method = RequestMethod.GET, consumes = {"application/jason","application/xml"},produces = {"application/jason","application/xml"})
    @GetMapping("/api/comarcas/{id}") //Substitui o @RequestMapping
    @ResponseBody  // <= isso informa que o metodo abaixo retornará como corpo da requisição
    public ResponseEntity getComarcaById(@PathVariable Integer id){
        Optional<Comarca> comarca = comarcas.findById(id);
        if(comarca.isPresent()){
            // Configurando a resposta
            // ResponseEntity<Comarca> responseEntity = new ResponseEntity<Comarca>(HttpStatus.OK);
            return ResponseEntity.ok(comarca.get());
        }
        return ResponseEntity.notFound().build();
    }
}