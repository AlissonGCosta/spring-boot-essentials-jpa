package br.com.costa.spring_boot_essentials.controller;

import br.com.costa.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.costa.spring_boot_essentials.dtos.ExerciciosDto;
import br.com.costa.spring_boot_essentials.services.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

     @GetMapping
     @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll() {
        return exerciciosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ExerciciosDto exerciciosDto) {
         exerciciosService.save(exerciciosDto);
    }

    @GetMapping("/grupos/{grupoMuscular}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> getExerciciosDtoByGrupoMuscular(@PathVariable String grupoMuscular) {
         return exerciciosService.getExerciciosDtoByGrupoMuscular(grupoMuscular);
    }

}
