package com.cursojava.pmanager.domain.repository;

import com.cursojava.pmanager.domain.entity.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembroRepository extends JpaRepository<Membro, Long> {

    Optional<Membro> findByIdAndDesativo(Long id, boolean desativo);

    Optional<Membro> findByEmailAndDesativo(String email, boolean desativo);
}
