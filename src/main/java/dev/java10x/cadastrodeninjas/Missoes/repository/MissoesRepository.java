package dev.java10x.cadastrodeninjas.Missoes.repository;

import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel,Long> {
}
