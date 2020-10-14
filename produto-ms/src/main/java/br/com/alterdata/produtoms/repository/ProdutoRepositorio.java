package br.com.alterdata.produtoms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alterdata.produtoms.model.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

    List<Produto> findByIdProdutoIn(List<Integer> id);
}
/*//Lá no Microsserviço de produtos, você vai ter algo assim
    // no teu repositório List<Produto> findByIdIn(List<Integer> ids);

    //No teu service, tu vai chamar esse método passando como parâmetro a 
    lista de ids que recebeu no endpoint
    */