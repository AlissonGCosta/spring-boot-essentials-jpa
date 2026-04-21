package br.com.costa.spring_boot_essentials.database.model.repository;


import br.com.costa.spring_boot_essentials.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {

}
