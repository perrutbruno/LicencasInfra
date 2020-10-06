package br.com.alterdata.produtoms.service;

import java.util.List;

import br.com.alterdata.produtoms.dto.ProdutoDto;

public interface ProdutoService {

	ProdutoDto cadastrarProduto(ProdutoDto dto);

	List<ProdutoDto> obterTodos();
    
}
