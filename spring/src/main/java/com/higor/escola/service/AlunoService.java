package com.higor.escola.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higor.escola.model.Aluno;
import com.higor.escola.respository.AlunoRepository;

@Service
public class AlunoService{
    
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno adicionarAluno(Aluno aluno){

        aluno = alunoRepository.save(aluno);

        return aluno;

    }

    public Optional<Aluno> buscarAluno(Long id){

        Optional<Aluno> aluno = alunoRepository.findById(id);

        if(!aluno.isPresent())
            throw new ObjectNotFoundException(id.toString(), Aluno.class);

        return aluno;
    }

    public List<Aluno> listarAlunos() {

        List<Aluno> alunos = alunoRepository.findAll();

        return alunos;

    }

    public Aluno atualizarAluno(Long id, Aluno body){

        Optional<Aluno> alunoExists = alunoRepository.findById(id);

        if(!alunoExists.isPresent())
            throw new ObjectNotFoundException(id.toString(), Aluno.class);

        Aluno aluno = alunoExists.get();
        
        aluno.setNome(body.getNome());
        aluno.setIdade(body.getIdade());

        alunoRepository.save(aluno);

        return aluno;

    }
    
    public void deletarAluno(Long id){

        Optional<Aluno> alunoExists = alunoRepository.findById(id);

        if(!alunoExists.isPresent())
            throw new ObjectNotFoundException(id.toString(), Aluno.class);

        alunoRepository.deleteById(id);

    }
}