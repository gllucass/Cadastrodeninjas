package dev.java10x.cadastrodeninjas.Ninjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas/")

    public class NinjaController {
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
        public String mostrarTodosOsNinjas(){
            return "listar todos os Ninjas";
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
