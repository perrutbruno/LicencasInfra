package br.com.alterdata.chavelicencams.service;

import java.util.List;
import java.util.Optional;

import br.com.alterdata.chavelicencams.dto.ChaveLicencaDto;

public interface ChaveLicencaService {
    ChaveLicencaDto cadastrarChaveLicenca(ChaveLicencaDto dto);
	List<ChaveLicencaDto> obterTodos();
	Optional<ChaveLicencaDto> obterPorId(Integer id);
    
}
