package br.com.alterdata.setorms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.setorms.dto.SetorDto;
import br.com.alterdata.setorms.model.Setor;
import br.com.alterdata.setorms.repository.SetorRepositorio;

@Service
public class SetorServiceImpl implements SetorService {
    @Autowired
    private SetorRepositorio repoSetor;

    @Override
    public SetorDto cadastrarSetor(SetorDto setor) {
        return salvarSetor(setor);
    }

    private SetorDto salvarSetor(SetorDto setor) {
        ModelMapper mapper = new ModelMapper();

        Setor setorEntidade = mapper.map(setor, Setor.class);
        setorEntidade = repoSetor.save(setorEntidade);

        return mapper.map(setorEntidade, SetorDto.class);
    }

    @Override
    public List<SetorDto> obterTodos() {
        List<Setor> setores = repoSetor.findAll();

        return setores.stream()
            .map(setor -> new ModelMapper().map(setor, SetorDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<SetorDto> obterPorNome(String nomeSetor) {
        Optional<Setor> setor = repoSetor.findByNomeSetor(nomeSetor);
        if(setor.isPresent()) {
            return Optional.of(new ModelMapper().map(setor.get(), SetorDto.class));
        }
 
        return Optional.empty();
    }
}
