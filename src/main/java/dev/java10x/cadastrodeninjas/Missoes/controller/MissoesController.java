package dev.java10x.cadastrodeninjas.Missoes.controller;

import dev.java10x.cadastrodeninjas.Missoes.dto.MissoesDTO;
import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import dev.java10x.cadastrodeninjas.Missoes.service.MissoesService;
import dev.java10x.cadastrodeninjas.Ninjas.dto.NinjaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    //GET -- Mandar uma requisicao para mostrar missao por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> listarMissaoPorId(@PathVariable Long id){
        MissoesDTO missoesDTO = missoesService.listarMissaoPorId(id);
        if(missoesDTO != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(missoesDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("A Missao com o ID: " + id + " não existe nos nossos registros");
    }

    //POST -- Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public ResponseEntity<MissoesDTO> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missoes = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missoes);
    }

    //PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Object> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizado){
        MissoesDTO missao = missoesService.listarMissaoPorId(id);
        if(missao != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(missoesAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("A missao com o ID: " + id + " não existe nos nossos registros");
    }

    //DELETE -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        MissoesDTO missao = missoesService.listarMissaoPorId(id);
        if (missao != null){
           missoesService.deletarMissao(id);
            return ResponseEntity.ok()
                    .body("Missao de ID: " + id +" Deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O Ninja com o ID: " + id + " não existe nos nossos registros");
    }

}
