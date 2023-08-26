package com.higor.escola.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.higor.escola.model.Escola;
import com.higor.escola.respository.EscolaRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EscolaControllerTest {
    
    @Autowired
    private WebTestClient webClient;

    @Autowired
    private EscolaRepository escolaRepository;

    private Long lastId = 0L;

    private Escola escola;

    @BeforeEach
    public void setUp(){
        webClient.mutate().responseTimeout(Duration.ofMillis(10000)).build();
        escolaRepository.deleteAll();
        escola = new Escola("teste");
    }

    @Test
    public void deve_cadastrar_escola(){
        webClient.post().uri("/escola").accept(MediaType.ALL)
            .body(BodyInserters.fromValue(escola))
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(Escola.class).value(o -> {
                lastId = o.getId();
                assertTrue(o.getId() > 0);
            });
    }

}
