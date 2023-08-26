package com.higor.escola.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.higor.escola.model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Long>{
    
}
