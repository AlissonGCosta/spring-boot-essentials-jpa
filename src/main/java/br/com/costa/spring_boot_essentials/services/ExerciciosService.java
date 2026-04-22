package br.com.costa.spring_boot_essentials.services;

import br.com.costa.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.costa.spring_boot_essentials.database.model.repository.IExerciciosRepository;
import br.com.costa.spring_boot_essentials.dtos.ExerciciosDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class ExerciciosService {

    private final IExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll() {
        return exerciciosRepository.findAll();
    }

    public void save(@Valid @RequestBody ExerciciosDto exerciciosDto) {
        exerciciosRepository.save(ExerciciosEntity.builder()
                        .nome(exerciciosDto.getNome())
                        .grupoMuscular(exerciciosDto.getGrupoMuscular())
                .build());
    }

    public List<ExerciciosEntity> getExerciciosDtoByGrupoMuscular(String grupoMuscular) {
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }

}
