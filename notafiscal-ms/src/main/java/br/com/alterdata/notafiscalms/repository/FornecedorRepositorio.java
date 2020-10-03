package br.com.alterdata.notafiscalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alterdata.notafiscalms.model.Fornecedor;

public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Integer> {
    
}
