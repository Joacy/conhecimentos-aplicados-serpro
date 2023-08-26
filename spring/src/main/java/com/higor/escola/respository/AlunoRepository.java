package com.higor.escola.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.higor.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
