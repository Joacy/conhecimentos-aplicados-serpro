package com.higor.escola.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
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

import com.higor.escola.model.Aluno;
import com.higor.escola.service.AlunoService;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno){

        aluno  = alunoService.adicionarAluno(aluno);

        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> find(@PathVariable("id") Long id){

        try {
            Optional<Aluno> aluno = alunoService.buscarAluno(id);            
            return new ResponseEntity<Aluno>(aluno.get(), HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Aluno>> index() {

        List<Aluno> alunos = alunoService.listarAlunos();

        return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> update(@PathVariable("id") Long id, @RequestBody Aluno body){

        try {
            Optional<Aluno> aluno = alunoService.buscarAluno(id);
    
            return new ResponseEntity<Aluno>(aluno.get(), HttpStatus.OK);
            
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
        }

    }
    

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> delete(@PathVariable("id") Long id){

        try {
            alunoService.deletarAluno(id);
            
            return new ResponseEntity<Aluno>(HttpStatus.OK);

        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
        }

    }

}
