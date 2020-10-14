package br.com.alterdata.notafiscalms.service;

import java.util.List;

import br.com.alterdata.notafiscalms.dto.NotaFiscalDto;

public interface NotaFiscalService {
    NotaFiscalDto cadastrarNotaFiscal(NotaFiscalDto dto);

	List<NotaFiscalDto> obterTodos();
}
