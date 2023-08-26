package com.higor.escola.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import org.springframework.web.reactive.function.BodyInserters;

import com.higor.escola.model.Aluno;
import com.higor.escola.respository.AlunoRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlunoControllerTest {
    
    private Aluno aluno;

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private AlunoRepository alunoRepository;

    @BeforeEach
    public void init(){
        webClient.mutate().responseTimeout(Duration.ofMillis(10000)).build();
        aluno = new Aluno("teste", 16);
        alunoRepository.deleteAll();
    }

    private Long lastId = 0L;

    @Test
    public void deve_criar_aluno_e_retonar_aluno_criado(){

        adicionar_aluno_na_api()
        .expectStatus()
        .isOk()
        .expectBody(Aluno.class).value(o -> { 
            lastId = o.getId();
            assertTrue(o.getId() > 0);
        });

    }

    @Test
    public void nao_deve_retornar_aluno_inexistente(){
        webClient.get().uri("/aluno/{id}", 1).accept(MediaType.ALL).exchange()
        .expectStatus().isNotFound();
    }

    @Test
    public void deve_retornar_aluno(){
        deve_criar_aluno_e_retonar_aluno_criado();

        webClient.get().uri("/aluno/{id}", lastId).accept(MediaType.ALL).exchange()
        .expectStatus()
        .isOk()
        .expectBody(Aluno.class).value(o -> assertEquals(lastId, o.getId()));
    }

    @Test
    public void deve_retornar_todos_alunos(){
        deve_criar_aluno_e_retonar_aluno_criado();
        deve_criar_aluno_e_retonar_aluno_criado();
        deve_criar_aluno_e_retonar_aluno_criado();

        webClient.get().uri("/aluno").accept(MediaType.ALL).exchange()
        .expectStatus()
        .isOk()
        .expectBodyList(Aluno.class)

        .value(o -> assertEquals(3, o.size()));
        
    }

    @Test
    public void deve_deletar_usuario(){

        deve_criar_aluno_e_retonar_aluno_criado();

        webClient.delete().uri("/aluno/{id}", lastId).accept(MediaType.ALL).exchange()
        .expectStatus().isOk();

    }

    @Test
    public void nao_deve_deletar_usuario_inexistente(){

        webClient.delete().uri("/aluno/{id}", lastId).accept(MediaType.ALL).exchange()
        .expectStatus().isNotFound();

    }

    public ResponseSpec adicionar_aluno_na_api(){
        return webClient.post().uri("/aluno").accept(MediaType.ALL)
        .body(BodyInserters.fromValue(aluno))
        .exchange();
    }

}
