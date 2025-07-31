package dev.java10x.cadastrodeninjas.Ninjas.service;


import dev.java10x.cadastrodeninjas.Ninjas.model.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository=ninjaRepository;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }


}
