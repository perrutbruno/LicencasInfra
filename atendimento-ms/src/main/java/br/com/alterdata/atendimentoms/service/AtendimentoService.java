package br.com.alterdata.atendimentoms.service;

import java.util.List;
import java.util.Optional;

import br.com.alterdata.atendimentoms.dto.AtendimentoDto;

public interface AtendimentoService {
    AtendimentoDto cadastrarAtendimento(AtendimentoDto dto);
    List<AtendimentoDto> obterTodos();
    Optional<AtendimentoDto> obterPorNumero(String nomeSetor);
	Optional<AtendimentoDto> obterPorId(Integer id);
}
