package dev.java10x.cadastrodeninjas.Ninjas.repository;

import dev.java10x.cadastrodeninjas.Ninjas.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel,Long> {
}
