package dev.java10x.cadastrodeninjas.Ninjas.controller;

import dev.java10x.cadastrodeninjas.Ninjas.model.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado com sucesso";
    }

    //Mostrar Ninja (Read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (Read)
    @GetMapping("/listarID")
    public String mostrarNinjasPorID(){
        return "Listar Ninja Por ID";
    }

    //Alterar dados dos Ninjas (Update)
    @PutMapping("/alterarID")
    public String alterarNinjasPorId(){
        return "Alterar Ninjas Por ID";
    }

    //Deletar Ninja (Delete)
    @DeleteMapping("deletarID")
    public String deletarNinjaPorId(){
        return "Deletar Ninjas Por ID";
    }

}
