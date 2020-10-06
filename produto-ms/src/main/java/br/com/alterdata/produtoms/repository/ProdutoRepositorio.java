package br.com.alterdata.produtoms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alterdata.produtoms.model.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
    
}
