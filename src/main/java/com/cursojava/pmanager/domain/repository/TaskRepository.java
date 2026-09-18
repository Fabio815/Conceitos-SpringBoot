package com.cursojava.pmanager.domain.repository;

import com.cursojava.pmanager.domain.entity.Task;
import com.cursojava.pmanager.domain.model.TaskStatus;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(
        """
        select t
        from Task t where (:projetoId is null or t.projeto.id=:projetoId) and
                          (:membroId is null or t.assigedMembro.id=:membroId) and
                          (:status is null or t.status=:status) and
                          (:tituloParcial is null or upper(t.titulo) like concat('%', upper(:tituloParcial), '%'))
        """)
    Page<Task> find(
            @Param("projetoId") Long projetoId,
            @Param("membroId") Long membroId,
            @Param("status") TaskStatus status,
            @Param("tituloParcial") String tituloParcial,
            Pageable pageable
    );
    /*List<Task> find(
            @Param("projetoId") Long projetoId,
            @Param("membroId") Long membroId,
            @Param("status") TaskStatus status,
            @Param("tituloParcial") String tituloParcial);*/
}