package dev.java10x.cadastrodeninjas.Missoes.controller;

import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import dev.java10x.cadastrodeninjas.Missoes.service.MissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {


    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //GET -- Mandar uma requisicao para mostrar missao por id
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    //POST -- Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoesModel){
        return missoesService.criarMissao(missoesModel);
    }

    //PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao Alterada com sucesso";
    }

    //DELETE -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao Deletada com sucesso";
    }

}
