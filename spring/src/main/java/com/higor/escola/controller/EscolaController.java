package com.higor.escola.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.higor.escola.model.Escola;
import com.higor.escola.service.EscolaService;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    
    @Autowired
    private EscolaService escolaService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Escola> save(@RequestBody Escola escola){

        return new ResponseEntity<Escola>(escolaService.adicionarEscola(escola), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Escola> find(@PathVariable("id") Long id){
        
        try {   
            return new ResponseEntity<Escola>(escolaService.buscarEscola(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Escola>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Escola>> index(){
        
        return new ResponseEntity<List<Escola>>(escolaService.listarEscola(), HttpStatus.OK);

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Escola> update(@PathVariable("id") Long id, @RequestBody Escola escola){
        
        try {
            return new ResponseEntity<Escola>(escolaService.atualizarEscola(id, escola), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Escola>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Escola> delete(@PathVariable("id") Long id){
        try {
            escolaService.deletarEscola(id);
            return new ResponseEntity<Escola>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Escola>(HttpStatus.NOT_FOUND);
        }        
    }

}
