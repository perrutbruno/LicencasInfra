package br.com.alterdata.setorms.service;

import java.util.List;
import java.util.Optional;

import br.com.alterdata.setorms.dto.SetorDto;

public interface SetorService {
    SetorDto cadastrarSetor(SetorDto dto);

    List<SetorDto> obterTodos();
    Optional<SetorDto> obterPorNome(String nomeSetor);
}
