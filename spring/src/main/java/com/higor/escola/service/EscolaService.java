package com.higor.escola.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higor.escola.model.Escola;
import com.higor.escola.respository.EscolaRepository;

@Service
public class EscolaService {
    
    @Autowired
    private EscolaRepository escolaRepository;

    public Escola adicionarEscola(Escola escola){
        
        return escolaRepository.save(escola);
    }

    public Optional<Escola> buscarEscola(Long id){
        Optional<Escola> escola = escolaRepository.findById(id);

        if(!escola.isPresent())
            throw new ObjectNotFoundException(id.toString(), Escola.class);
    
        return escola;
    }

    public List<Escola> listarEscola(){
        List<Escola> escolas = escolaRepository.findAll();

        return escolas;
    }

    public Escola atualizarEscola(Long id, Escola novaEscola){
        Optional<Escola> escolaExiste = escolaRepository.findById(id);

        if(!escolaExiste.isPresent())
            throw new ObjectNotFoundException(id.toString(), Escola.class);

        Escola escola = escolaExiste.get();

        if(novaEscola.getNome() != null){
            escola.setNome(novaEscola.getNome());
        }

        return escolaRepository.save(escola);
    }

    public void deletarEscola(Long id){
        Optional<Escola> escolaExiste = escolaRepository.findById(id);

        if(!escolaExiste.isPresent())
            throw new ObjectNotFoundException(id.toString(), Escola.class);

        escolaRepository.deleteById(id);
    }
}
