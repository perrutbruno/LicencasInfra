package br.com.alterdata.fornecedorms.service;

import java.util.List;
import java.util.Optional;

import br.com.alterdata.fornecedorms.dto.FornecedorDto;
import br.com.alterdata.fornecedorms.model.Fornecedor;

public interface FornecedorService {

    FornecedorDto cadastrarFornecedor(FornecedorDto dto);
    
    Fornecedor atualizaFornecedor(Integer id, Fornecedor fornecedor);

    List<FornecedorDto> obterTodos();
    
    Optional<FornecedorDto> obterPorId(Integer id);

    Optional<FornecedorDto> obterPorNome(String nomeFornecedor);

	void removerFornecedor(Integer id);

}
