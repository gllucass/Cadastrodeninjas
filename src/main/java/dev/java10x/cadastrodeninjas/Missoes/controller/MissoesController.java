package dev.java10x.cadastrodeninjas.Missoes.controller;

import dev.java10x.cadastrodeninjas.Missoes.dto.MissoesDTO;
import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import dev.java10x.cadastrodeninjas.Missoes.service.MissoesService;
import dev.java10x.cadastrodeninjas.Ninjas.dto.NinjaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Lista todos as missoes cadastrados", description = "Essa rota lista todas as missoes cadastrados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ninjas exibida com sucesso"),
    })
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    //GET -- Mandar uma requisicao para mostrar missao por id
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por Id", description = "Essa rota lista um ninja pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<Object> listarMissaoPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id){
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
    @Operation(summary = "Cria uma nova missao", description = "Essa rota cria uma nova missao e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missao criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao da missão, parametros incorretos")
    })
    public ResponseEntity<MissoesDTO> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missoes = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missoes);
    }

    //PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar dados da Missao por Id", description = "Essa rota Alterar dados da missao pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não alterado")
    })
    public ResponseEntity<Object> alterarMissao(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados da missao a serem atualizados no corpo da requisicao")
            @RequestBody MissoesDTO missoesAtualizado){
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
    @Operation(summary = "Excluir uma missao pelo seu Id", description = "Essa rota exclui a missao pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao não encontrada, e não foi deletada")
    })
    public ResponseEntity<String> deletarMissao(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id){
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
