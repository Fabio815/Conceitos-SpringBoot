package com.cursojava.pmanager.domain.repository;

import com.cursojava.pmanager.domain.entity.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    Optional<Membro> findByIdAndDesativo(Long id, boolean desativo);

    Optional<Membro> findByEmailAndDesativo(String email, boolean desativo);


}
