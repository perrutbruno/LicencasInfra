package br.com.alterdata.notafiscalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alterdata.notafiscalms.model.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
    
}
