package dev.java10x.cadastrodeninjas.Ninjas.model;

import dev.java10x.cadastrodeninjas.Missoes.model.MissoesModel;
import jakarta.persistence.*;
import lombok.*;


//Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //@ManyToOne - um ninja pode ter apenas uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key ou Chave estrangeira
    private MissoesModel missoes;
}
