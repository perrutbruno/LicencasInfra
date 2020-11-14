package br.com.alterdata.chavelicencams.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.chavelicencams.dto.ChaveLicencaDto;
import br.com.alterdata.chavelicencams.model.ChaveLicenca;
import br.com.alterdata.chavelicencams.repository.ChaveLicencaRepositorio;

@Service
public class ChaveLicencaServiceImpl implements ChaveLicencaService {
    @Autowired
    private ChaveLicencaRepositorio repoChaveLicenca;

    @Override
    public ChaveLicencaDto cadastrarChaveLicenca(ChaveLicencaDto chave) {
        chave.setAtivo(1);
        return salvarChave(chave);
    }

    private ChaveLicencaDto salvarChave(ChaveLicencaDto chave) {
        ModelMapper mapper = new ModelMapper();

        ChaveLicenca chaveLicencaEntidade = mapper.map(chave, ChaveLicenca.class);
        chaveLicencaEntidade = repoChaveLicenca.save(chaveLicencaEntidade);

        return mapper.map(chaveLicencaEntidade, ChaveLicencaDto.class);
    }

    @Override
    public List<ChaveLicencaDto> obterTodos() {
        List<ChaveLicenca> chaveLicenca = repoChaveLicenca.findAll();

        return chaveLicenca.stream().map(chave -> new ModelMapper().map(chave, ChaveLicencaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ChaveLicencaDto> obterPorId(Integer id) {
        Optional<ChaveLicenca> chaveLicenca = repoChaveLicenca.findById(id);

        if(chaveLicenca.isPresent()) {
            return Optional.of(new ModelMapper().map(chaveLicenca.get(), ChaveLicencaDto.class));
        }
 
        return Optional.empty();
    }

    
}
