package com.cursojava.pmanager.domain.entity;

import com.cursojava.pmanager.domain.model.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 36)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 150)
    private String descricao;

    @Column(name = "numeros_de_dias", nullable = false)
    private Integer numerosDeDias;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "assined_member")//Relacionameto é unidirecional, não preciso que fazer nada na Membro, pois é só a tasks que enxerga.
    private Membro assigedMembro;

}