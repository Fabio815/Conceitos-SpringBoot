package com.cursojava.pmanager.domain.entity;

import com.cursojava.pmanager.domain.model.StatusProjeto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
//Usando lombok para tirar o BoilerPlate que é o código que não faz parte na regra de negócio, no caso não preciso dele para entender o fluxo do código (get, set, construtor, etc...).
@Entity
@Table(name = "projeto")
@Data //Basicamente aqui vou pré definir os gets, sets, hash, toSting etc...
@Builder //Usado para facilitar a instância de objetos (facilita  muito).
@AllArgsConstructor //Cria um construtur com elementos.
@NoArgsConstructor //Construtur sem elementos
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",  nullable = false, length = 80)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 150)
    private String descricao;

    @Column(name = "data_inicial", nullable = false)
    private LocalDate dataInicial;

    @Column(name = "data_final", nullable = false)
    private LocalDate dataFinal;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;
}