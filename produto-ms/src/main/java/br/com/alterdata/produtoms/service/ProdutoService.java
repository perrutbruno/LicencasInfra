package br.com.alterdata.produtoms.service;

import java.util.List;

import br.com.alterdata.produtoms.dto.ProdutoDto;
import br.com.alterdata.produtoms.model.Produto;

public interface ProdutoService {

	ProdutoDto cadastrarProduto(ProdutoDto dto);

	List<ProdutoDto> obterTodos();

	List<ProdutoDto> obterProdutosNotaFiscal(List<Integer> id);

	Produto atualizaProduto(Integer id, Produto produto);
	void removerProduto(Integer id);
	
	
}
