package dev.java10x.cadastrodeninjas.config.converter;

import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import dev.java10x.cadastrodeninjas.Missoes.repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Esta classe ensina ao Spring como converter uma String (que será o ID da missão)
 * em um objeto completo do tipo MissoesModel.
 */
@Component // Anotação para que o Spring encontre e gerencie esta classe.
public class StringToMissoesModelConverter implements Converter<String, MissoesModel> {

    // Injetamos o repositório para poder buscar a missão no banco de dados.
    @Autowired
    private MissoesRepository missoesRepository;

    @Override
    public MissoesModel convert(String source) {
        // 'source' é o valor que vem do formulário (o ID da missão como texto).

        // Se o valor for nulo ou vazio (opção "-- Sem Missão --"), retornamos null.
        if (source == null || source.isEmpty()) {
            return null;
        }

        // Convertemos a String para Long.
        Long id = Long.valueOf(source);

        // Buscamos a missão no banco pelo ID e a retornamos.
        // O .orElse(null) garante que, se não encontrar, ele retorna nulo.
        return missoesRepository.findById(id).orElse(null);
    }
}