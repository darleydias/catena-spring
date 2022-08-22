package com.github.darleydias.api.controller;

import com.github.darleydias.domain.entity.Comarca;
import com.github.darleydias.domain.repository.Comarcas;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ComarcaController {
    private Comarcas comarcas; //DAO

    public ComarcaController(Comarcas comarcas) {
        this.comarcas = comarcas;
    }
    @GetMapping("/api/comarcas/{id}") //Substitui o @RequestMapping
    @ResponseBody  // <= isso informa que o metodo abaixo retornará como corpo da requisição
    public ResponseEntity getComarcaById(@PathVariable Integer id){
        Optional<Comarca> comarca = comarcas.findById(id);
        if(comarca.isPresent()){
            return ResponseEntity.ok(comarca.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/api/comarcas")
    @ResponseBody
    public ResponseEntity save(@RequestBody Comarca comarca){
        Comarca comarcaSalva = comarcas.save(comarca);
        return ResponseEntity.ok(comarcaSalva);
    }
}