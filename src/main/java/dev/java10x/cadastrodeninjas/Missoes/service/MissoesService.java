package dev.java10x.cadastrodeninjas.Missoes.service;

import dev.java10x.cadastrodeninjas.Missoes.dto.MissoesDTO;
import dev.java10x.cadastrodeninjas.Missoes.mapper.MissoesMapper;
import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import dev.java10x.cadastrodeninjas.Missoes.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;


    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar missoes por ID
    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missoePorId = missoesRepository.findById(id);
        return missoePorId.map(missoesMapper::map).orElse(null);
    }

    //Criar uma nova missao
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes =  missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    //Deletar uma missao
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //Atualizar uma missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO MissoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(MissoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
