package dev.java10x.cadastrodeninjas.Ninjas.controller;

import dev.java10x.cadastrodeninjas.Ninjas.dto.NinjaDTO;
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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar Ninja (Read)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (Read)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    //Alterar dados dos Ninjas (Update)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjasPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaatuAlizado){
        return ninjaService.atualizarNinja(id, ninjaatuAlizado);
    }

    //Deletar Ninja (Delete)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

}
