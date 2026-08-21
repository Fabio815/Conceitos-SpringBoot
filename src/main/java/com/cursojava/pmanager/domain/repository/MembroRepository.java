package com.cursojava.pmanager.domain.repository;

import com.cursojava.pmanager.domain.entity.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    Optional<Membro> findByIdAndDesativo(Long id, boolean desativo);

    Optional<Membro> findByEmailAndDesativo(String email, boolean desativo);

    //JPQL - Mais eficaz pois não precisa percorrer um array e selecionar apeas os ativos.
    @Query("from Membro as m where m.desativo = false order by m.nome")
    List<Membro> findAllNotDeleted();
    /*default List<Membro> findAllNotDeleted() {//declarando uma função, preciso colocar o default
        return findAll()
                .stream()
                .filter(m -> !m.getDesativo())
                .toList();
    }*/
}
