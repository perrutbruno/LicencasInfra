package br.com.alterdata.chavelicencams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alterdata.chavelicencams.model.ChaveLicenca;

public interface ChaveLicencaRepositorio extends JpaRepository<ChaveLicenca, Integer> {
    
}