package dev.java10x.cadastrodeninjas.Ninjas.controller;

import dev.java10x.cadastrodeninjas.Ninjas.dto.NinjaDTO;
import dev.java10x.cadastrodeninjas.Ninjas.model.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoNinja);
    }

    //Mostrar Ninja (Read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok()
                .body(ninjas);

    }

    //Mostrar Ninja por ID (Read)
    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> listarNinjaPorId(@PathVariable Long id){
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
    public ResponseEntity<Object> alterarNinjasPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaatuAlizado){
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
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID:" + id +  " Deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O Ninja com o ID: " + id + " não existe nos nossos registros");
    }

}
