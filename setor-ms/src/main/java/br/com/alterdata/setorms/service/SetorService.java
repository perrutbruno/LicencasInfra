package br.com.alterdata.setorms.service;

import java.util.List;
import java.util.Optional;

import br.com.alterdata.setorms.dto.SetorDto;
import br.com.alterdata.setorms.model.Setor;

public interface SetorService {
    SetorDto cadastrarSetor(SetorDto dto);
    List<SetorDto> obterTodos();
    Optional<SetorDto> obterPorNome(String nomeSetor);
    Optional<SetorDto> obterPorId(Integer id);
	Setor atualizaSetor(Integer id, Setor setor);
	void removerSetor(Integer id);
}
