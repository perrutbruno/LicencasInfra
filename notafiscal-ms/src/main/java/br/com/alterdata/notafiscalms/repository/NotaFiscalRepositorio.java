package br.com.alterdata.notafiscalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alterdata.notafiscalms.model.NotaFiscal;

@Repository
public interface NotaFiscalRepositorio extends JpaRepository<NotaFiscal, Integer> {
    

}
