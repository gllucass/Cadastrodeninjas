package dev.java10x.cadastrodeninjas.Missoes.service;

import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import dev.java10x.cadastrodeninjas.Missoes.repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }
}
