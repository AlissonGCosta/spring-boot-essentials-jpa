package br.com.costa.spring_boot_essentials.database.model;

import jdk.jshell.Snippet;
import lombok.*;


import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoModel {
    private int id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;

}


