package com.cursojava.pmanager.domain.entity;

import com.cursojava.pmanager.domain.model.StatusProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//Usando lombok para tirar o BoilerPlate que é o código que não faz parte na regra de negócio, no caso não preciso dele para entender o fluxo do código (get, set, construtor, etc...).
@Data //Basicamente aqui vou pré definir os gets, sets, hash, toSting etc...
@Builder //Usado para facilitar a instância de objetos (facilita  muito).
@AllArgsConstructor //Cria um construtur com elementos.
@NoArgsConstructor //Construtur sem elementos
public class Projeto {
    private String id;
    private String nome;
    private String descricao;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    private StatusProjeto status;
}