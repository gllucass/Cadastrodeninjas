package dev.java10x.cadastrodeninjas.Missoes.model;

import dev.java10x.cadastrodeninjas.Ninjas.model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //@OneToMany - Uma missão pode ter mais de um ninja
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

}
