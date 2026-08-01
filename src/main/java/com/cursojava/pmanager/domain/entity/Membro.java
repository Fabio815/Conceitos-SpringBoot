package com.cursojava.pmanager.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "secreto", nullable = false, length = 36)
    private String secreto;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "email", nullable = false, length = 80)
    private String email;

    @Column(name = "desativo", nullable = false)
    private Boolean desativo;
}
