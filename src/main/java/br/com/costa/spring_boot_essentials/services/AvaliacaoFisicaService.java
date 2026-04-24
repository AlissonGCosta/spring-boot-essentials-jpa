package br.com.costa.spring_boot_essentials.services;

import br.com.costa.spring_boot_essentials.database.model.AlunosEntity;
import br.com.costa.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.costa.spring_boot_essentials.database.model.repository.IAlunosRepository;
import br.com.costa.spring_boot_essentials.database.model.repository.IAvaliacoesFisicasRepository;
import br.com.costa.spring_boot_essentials.dtos.AvaliacaoFisicaDto;
import br.com.costa.spring_boot_essentials.exception.BadRequestException;
import br.com.costa.spring_boot_essentials.exception.NotFoundException;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
       AlunosEntity novoAluno =  alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacoesFisicasEntity avaliacoesFisica = novoAluno.getAvaliacoesFisicas();
        if(avaliacoesFisica != null) {
            throw new BadRequestException("Avaliação fisica ja cadastra para este aluno");
        }

        avaliacoesFisica = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPercentualGorduraCorporal())
                .build();


        novoAluno.setAvaliacoesFisicas(avaliacoesFisica);
        alunosRepository.save(novoAluno);


    }
}
