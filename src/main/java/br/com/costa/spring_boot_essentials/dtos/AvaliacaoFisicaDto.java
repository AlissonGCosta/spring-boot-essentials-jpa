package br.com.costa.spring_boot_essentials.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AvaliacaoFisicaDto {

    @NotNull
    private Integer alunoId;
    @NotNull
    private BigDecimal peso;
    @NotNull
    private BigDecimal altura;
    @NotNull
    private BigDecimal percentualGorduraCorporal;
}
