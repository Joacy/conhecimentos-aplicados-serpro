package com.higor.escola.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Aluno {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    public Aluno(){

    }

    public Aluno(String nome, Integer idade){
        super();
        this.nome = nome;
        this.idade = idade;
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

    public Integer getIdade(){
        return this.idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

}
