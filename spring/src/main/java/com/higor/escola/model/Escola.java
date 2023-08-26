package com.higor.escola.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Escola {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public Escola(){

    }

    public Escola(String nome){
        super();
        this.nome = nome;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
