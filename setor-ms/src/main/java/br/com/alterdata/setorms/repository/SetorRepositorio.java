package br.com.alterdata.setorms.repository;

import br.com.alterdata.setorms.model.Setor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepositorio extends JpaRepository<Setor, Integer>{

    Optional<Setor> findByNomeSetor(String nomeSetor);
    
}
