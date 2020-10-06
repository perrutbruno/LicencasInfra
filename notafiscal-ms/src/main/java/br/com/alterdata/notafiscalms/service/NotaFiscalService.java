package br.com.alterdata.notafiscalms.service;

import java.util.List;

import br.com.alterdata.notafiscalms.dto.NotaFiscalDto;

public interface NotaFiscalService {
    NotaFiscalDto cadastrarProduto(NotaFiscalDto dto);

	List<NotaFiscalDto> obterTodos();
}
