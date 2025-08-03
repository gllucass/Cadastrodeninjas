package dev.java10x.cadastrodeninjas.Missoes.service;

import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import dev.java10x.cadastrodeninjas.Missoes.repository.MissoesRepository;
import dev.java10x.cadastrodeninjas.Ninjas.model.NinjaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Listar missoes por ID
    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> missoePorId = missoesRepository.findById(id);
        return missoePorId.orElse(null);
    }

    //Criar uma nova missao
    public MissoesModel criarMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    //Deletar uma missao
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
