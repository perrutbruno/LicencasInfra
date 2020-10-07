package br.com.alterdata.fornecedorms.service;

import java.util.List;

import br.com.alterdata.fornecedorms.dto.FornecedorDto;
import br.com.alterdata.fornecedorms.model.Fornecedor;

public interface FornecedorService {

    FornecedorDto cadastrarFornecedor(FornecedorDto dto);
    
    FornecedorDto alterarFornecedor(Integer id, FornecedorDto dto);

    List<FornecedorDto> obterTodos();
    
    Fornecedor obterPorId(Integer id, FornecedorDto dto);
    
}
