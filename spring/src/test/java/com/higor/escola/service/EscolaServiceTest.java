package com.higor.escola.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.higor.escola.model.Escola;
import com.higor.escola.respository.EscolaRepository;

@ExtendWith(MockitoExtension.class)
public class EscolaServiceTest {

    @InjectMocks
    private EscolaService escolaService;

    @Mock
    private EscolaRepository escolaRepository;

    private Escola escola;

    @BeforeEach
    public void setUp(){
        escola  = new Escola("teste");
        escola.setId(1L);
    }

    @Test
    public void deve_cadastrar_escola(){
        when(escolaRepository.save(escola)).thenReturn(escola);

        assertEquals(1, escolaService.adicionarEscola(escola).getId());
    }

    @Test
    public void deve_atualizar_escola(){
        when(escolaRepository.findById(1L)).thenReturn(Optional.of(escola));

        when(escolaRepository.save(escola)).thenReturn(escola);

        Escola novaEscola = new Escola("novo");

        assertEquals("novo", escolaService.atualizarEscola(1L, novaEscola).getNome());

    }
    
}
