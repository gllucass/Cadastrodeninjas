package dev.java10x.cadastrodeninjas.Missoes.model;

import dev.java10x.cadastrodeninjas.Ninjas.model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //@OneToMany - Uma missão pode ter mais de um ninja
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
