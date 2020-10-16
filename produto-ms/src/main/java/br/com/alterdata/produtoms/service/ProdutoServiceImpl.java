package br.com.alterdata.produtoms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.produtoms.dto.ProdutoDto;
import br.com.alterdata.produtoms.model.Produto;
import br.com.alterdata.produtoms.repository.ProdutoRepositorio;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepositorio repoProduto;

    @Override
    public ProdutoDto cadastrarProduto(ProdutoDto produto) {
        return salvarProduto(produto);
    }

    private ProdutoDto salvarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();

        Produto produtoEntidade = mapper.map(produto, Produto.class);
        produtoEntidade = repoProduto.save(produtoEntidade);

        return mapper.map(produtoEntidade, ProdutoDto.class);
    }

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repoProduto.findAll();

        return produtos.stream()
            .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDto> obterProdutosNotaFiscal(List<Integer> id) {
        List<Produto> produtos = repoProduto.findByIdProdutoIn(id);

        return produtos.stream()
            .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
            .collect(Collectors.toList());
    }
}
