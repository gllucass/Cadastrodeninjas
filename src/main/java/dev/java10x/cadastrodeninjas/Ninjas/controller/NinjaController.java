package dev.java10x.cadastrodeninjas.Ninjas.controller;

import dev.java10x.cadastrodeninjas.Ninjas.dto.NinjaDTO;
import dev.java10x.cadastrodeninjas.Ninjas.model.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para acessar ela")
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (Create)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo Ninja", description = "Essa rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao da missão, parametros incorretos")
    })
    public ResponseEntity<NinjaDTO> criarNinja(
            @Parameter(description = "Usuário manda os dados do Ninja a ser criado no corpo da requisicao")
            @RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoNinja);
    }

    //Mostrar Ninja (Read)
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas cadastrados", description = "Essa rota lista todos os ninjas cadastrados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ninjas exibida com sucesso"),
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok()
                .body(ninjas);

    }

    //Mostrar Ninja por ID (Read)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por Id", description = "Essa rota lista um ninja pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<Object> listarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null){
            return ResponseEntity.ok()
                    .body(ninjaService.listarNinjaPorId(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O Ninja com o ID: " + id + " não existe nos nossos registros");
    }

    //Alterar dados dos Ninjas (Update)
    @PutMapping("/alterar/{id}")
    @GetMapping("/listar/{id}")
    @Operation(summary = "Alterar dados do Ninjas por Id", description = "Essa rota Alterar dados do Ninjas pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não alterado")
    })
    public ResponseEntity<Object> alterarNinjasPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do Ninja a serem atualizados no corpo da requisicao")
            @RequestBody NinjaDTO ninjaatuAlizado){

        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if(ninja != null){
            ninjaService.atualizarNinja(id, ninjaatuAlizado);
            return ResponseEntity.ok(ninja);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O Ninja com o ID: " + id + " não existe nos nossos registros");
    }

    //Deletar Ninja (Delete)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Excluir um ninja pelo seu Id", description = "Essa rota exclui o Ninja pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, e não foi deletado")
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID:" + id +  " Deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O Ninja com o ID: " + id + " não existe nos nossos registros");
    }

}
