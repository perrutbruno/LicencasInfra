package br.com.alterdata.chavelicencams.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.chavelicencams.dto.ChaveLicencaDto;
import br.com.alterdata.chavelicencams.model.ChaveLicenca;
import br.com.alterdata.chavelicencams.repository.ChaveLicencaRepositorio;

@Service
public class ChaveLicencaServiceImpl implements ChaveLicencaService{
    @Autowired
    private ChaveLicencaRepositorio repoChaveLicenca;

    @Override
    public ChaveLicencaDto cadastrarChaveLicenca(ChaveLicencaDto chave) {
        return salvarChave(chave);
    }

    private ChaveLicencaDto salvarChave(ChaveLicencaDto chave) {
        ModelMapper mapper = new ModelMapper();

        ChaveLicenca fornecedorEntidade = mapper.map(chave, ChaveLicenca.class);
        fornecedorEntidade = repoChaveLicenca.save(fornecedorEntidade);

        return mapper.map(fornecedorEntidade, ChaveLicencaDto.class);
    }

    @Override
    public List<ChaveLicencaDto> obterTodos() {
        List<ChaveLicenca> fornecedores = repoChaveLicenca.findAll();

        return fornecedores.stream()
            .map(chave -> new ModelMapper().map(chave, ChaveLicencaDto.class))
            .collect(Collectors.toList());
    }
}
