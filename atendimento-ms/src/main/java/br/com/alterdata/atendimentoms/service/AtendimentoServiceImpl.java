package br.com.alterdata.atendimentoms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.atendimentoms.dto.AtendimentoDto;
import br.com.alterdata.atendimentoms.model.Atendimento;
import br.com.alterdata.atendimentoms.repository.AtendimentoRepositorio;

@Service
public class AtendimentoServiceImpl implements AtendimentoService{
    @Autowired
    private AtendimentoRepositorio repoAtendimento;

    @Override
    public AtendimentoDto cadastrarAtendimento(AtendimentoDto setor) {
        return salvarAtendimento(setor);
    }

    private AtendimentoDto salvarAtendimento(AtendimentoDto atendimento) {
        ModelMapper mapper = new ModelMapper();

        Atendimento atendimentoEntidade = mapper.map(atendimento, Atendimento.class);
        atendimentoEntidade = repoAtendimento.save(atendimentoEntidade);

        return mapper.map(atendimentoEntidade, AtendimentoDto.class);
    }

    @Override
    public List<AtendimentoDto> obterTodos() {
        List<Atendimento> atendimentos = repoAtendimento.findAll();

        return atendimentos.stream()
            .map(setor -> new ModelMapper().map(setor, AtendimentoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<AtendimentoDto> obterPorNumero(String numeroAtendimento) {
        Optional<Atendimento> atendimento = repoAtendimento.findByNumeroAtendimento(numeroAtendimento);
        if(atendimento.isPresent()) {
            return Optional.of(new ModelMapper().map(atendimento.get(), AtendimentoDto.class));
        }
 
        return Optional.empty();
    }

    @Override
    public Optional<AtendimentoDto> obterPorId(Integer id) {
        Optional<Atendimento> atendimento = repoAtendimento.findById(id);

        if(atendimento.isPresent()) {
            return Optional.of(new ModelMapper().map(atendimento.get(), AtendimentoDto.class));
        }
 
        return Optional.empty();
    }




    
}
