package dev.java10x.cadastrodeninjas.Missoes.controllerUi;

import dev.java10x.cadastrodeninjas.Missoes.dto.MissoesDTO;
import dev.java10x.cadastrodeninjas.Missoes.service.MissoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {
    private final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "lista-missoes";
    }
    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "form-missao";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("missao", missoesService.listarMissaoPorId(id));
        return "form-missao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute("missao") MissoesDTO missao) {
        if (missao.getId() != null) {
            missoesService.atualizarMissao(missao.getId(), missao);
        } else {
            missoesService.criarMissao(missao);
        }
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
        return "redirect:/missoes/ui/listar";
    }
}
