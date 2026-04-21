package br.com.costa.spring_boot_essentials.database.model.repository;


import br.com.costa.spring_boot_essentials.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {
    
}
