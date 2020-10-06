package br.com.alterdata.fornecedorms.service;

import java.util.List;

import br.com.alterdata.fornecedorms.dto.FornecedorDto;

public interface FornecedorService {

	FornecedorDto cadastrarFornecedor(FornecedorDto dto);

	List<FornecedorDto> obterTodos();
    
}
