package dev.java10x.cadastrodeninjas.Ninjas.controllerUi;

import dev.java10x.cadastrodeninjas.Missoes.dto.MissoesDTO;
import dev.java10x.cadastrodeninjas.Missoes.service.MissoesService;
import dev.java10x.cadastrodeninjas.Ninjas.dto.NinjaDTO;
import dev.java10x.cadastrodeninjas.Ninjas.service.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    private final NinjaService ninjaService;
    private final MissoesService missoesService;

    public NinjaControllerUi(NinjaService ninjaService, MissoesService missoesService) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "index-ninja";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        List<MissoesDTO> todasAsMissoes = missoesService.listarMissoes();
        model.addAttribute("todasAsMissoes", todasAsMissoes);
        return "form-ninja";
    }

    /**
     * Exibe o formulário preenchido para editar um ninja existente.
     */
    @GetMapping("/editar/{id}")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        // A LINHA COM ERRO FOI REMOVIDA DAQUI.
        // Com o Converter e o th:field="*{missoes}", o Thymeleaf
        // pré-seleciona a missão correta automaticamente.

        model.addAttribute("ninja", ninja);
        List<MissoesDTO> todasAsMissoes = missoesService.listarMissoes();
        model.addAttribute("todasAsMissoes", todasAsMissoes);
        return "form-ninja";
    }

    /**
     * Recebe os dados do formulário (novo ou editado) e salva.
     */
    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute("ninja") NinjaDTO ninja) {
        if (ninja.getId() != null) {
            ninjaService.atualizarNinja(ninja.getId(), ninja);
        } else {
            ninjaService.criarNinja(ninja);
        }
        return "redirect:/ninjas/ui/listar";
    }

    /**
     * Exclui um ninja pelo ID e redireciona para a lista.
     */
    @GetMapping("/excluir/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }
}