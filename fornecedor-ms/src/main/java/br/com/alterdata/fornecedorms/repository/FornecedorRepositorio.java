package br.com.alterdata.fornecedorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alterdata.fornecedorms.model.Fornecedor;

public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Integer> {
    
}
