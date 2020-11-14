package br.com.alterdata.licenciamentoms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alterdata.licenciamentoms.model.Licenciamento;

public interface LicenciamentoRepositorio extends JpaRepository<Licenciamento, Integer> {

    Optional<Licenciamento> findById(Integer id);

    
}
