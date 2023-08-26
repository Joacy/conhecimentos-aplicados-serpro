package com.higor.escola.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.higor.escola.model.Aluno;
import com.higor.escola.respository.AlunoRepository;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {
    
    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    private Aluno aluno;

    @BeforeEach
    public void setUp(){
        aluno = new Aluno("teste", 16);
        aluno.setId(1L);
    } 

    @Test
    public void deve_criar_aluno_e_retonar_aluno_criado(){

        when(alunoRepository.save(aluno)).thenReturn(aluno);

        Aluno alunoAdicionado = alunoService.adicionarAluno(aluno);

        assertEquals("teste", alunoAdicionado.getNome());
    }

    @Test
    public void deve_retornar_aluno(){
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        Aluno aluno = alunoService.buscarAluno(1L).get();

        assertEquals(1L, aluno.getId());
    }

    @Test
    public void nao_deve_retornar_usuario_inexistente(){
        when(alunoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ObjectNotFoundException.class, ()->alunoService.buscarAluno(1L));

    }

}
