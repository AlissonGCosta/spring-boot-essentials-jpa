package br.com.costa.spring_boot_essentials.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ExerciciosDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
