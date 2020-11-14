package br.com.alterdata.licenciamentoms.service;

import java.util.List;

import br.com.alterdata.licenciamentoms.dto.LicenciamentoDto;

public interface LicenciamentoService {
    LicenciamentoDto cadastrarLicenciamento(LicenciamentoDto dto);

	List<LicenciamentoDto> obterTodos();

	List<LicenciamentoDto> obterProdutosNotaFiscal(List<Integer> id);
}
