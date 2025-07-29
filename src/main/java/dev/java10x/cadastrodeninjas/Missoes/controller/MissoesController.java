package dev.java10x.cadastrodeninjas.Missoes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes/")
public class MissoesController {

    //GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("listar")
    public String mostrarMissao(){
        return "Missao Listada com sucesso";
    }

    //POST -- Mandar uma requisicao para criar as missoes
    @PostMapping("criar")
    public String criarMissao(){
        return "Missao Criada com sucesso";
    }

    //PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping("alterar")
    public String alterarMissao(){
        return "Missao Alterada com sucesso";
    }

    //DELETE -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("deletar")
    public String deletarMissao(){
        return "Missao Deletada com sucesso";
    }

}
