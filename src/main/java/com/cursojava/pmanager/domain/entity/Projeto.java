package com.cursojava.pmanager.domain.entity;

import com.cursojava.pmanager.domain.model.StatusProjeto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//Usando lombok para tirar o BoilerPlate que é o código que não faz parte na regra de negócio, no caso não preciso dele para entender o fluxo do código (get, set, construtor, etc...).
@Entity
@Data //Basicamente aqui vou pré definir os gets, sets, hash, toSting etc...
@Builder //Usado para facilitar a instância de objetos (facilita  muito).
@AllArgsConstructor //Cria um construtur com elementos.
@NoArgsConstructor //Construtur sem elementos
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private String id;

    @Column(name = "nome",  nullable = false, length = 50)
    private String nome;

    @Column(name = "descrição", nullable = false, length = 150)
    private String descricao;

    @Column(name = "data_inicial", nullable = false)
    private LocalDateTime dataInicial;

    @Column(name = "data_final", nullable = false)
    private LocalDateTime dataFinal;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;
}