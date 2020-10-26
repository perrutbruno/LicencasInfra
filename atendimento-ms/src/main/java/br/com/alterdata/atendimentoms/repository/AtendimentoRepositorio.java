package br.com.alterdata.atendimentoms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alterdata.atendimentoms.model.Atendimento;

public interface AtendimentoRepositorio extends JpaRepository<Atendimento, Integer> {
    Optional<Atendimento> findByNumeroAtendimento(String numeroAtendimento);
	Optional<Atendimento> findById(Integer id);
}
