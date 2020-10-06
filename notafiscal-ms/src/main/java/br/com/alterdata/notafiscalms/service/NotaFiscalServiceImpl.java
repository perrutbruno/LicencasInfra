package br.com.alterdata.notafiscalms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.notafiscalms.dto.NotaFiscalDto;
import br.com.alterdata.notafiscalms.model.NotaFiscal;
import br.com.alterdata.notafiscalms.repository.NotaFiscalRepositorio;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {
    @Autowired
    private NotaFiscalRepositorio repoNotaFiscal;

    @Override
    public NotaFiscalDto cadastrarProduto(NotaFiscalDto notaFiscal) {
        return salvarProduto(notaFiscal);
    }

    private NotaFiscalDto salvarProduto(NotaFiscalDto notaFiscal) {
        ModelMapper mapper = new ModelMapper();

        NotaFiscal NotaFiscalEntidade = mapper.map(notaFiscal, NotaFiscal.class);
        NotaFiscalEntidade = repoNotaFiscal.save(NotaFiscalEntidade);

        return mapper.map(NotaFiscalEntidade, NotaFiscalDto.class);
    }

    @Override
    public List<NotaFiscalDto> obterTodos() {
        List<NotaFiscal> notasFiscais = repoNotaFiscal.findAll();

        return notasFiscais.stream()
            .map(notaFiscal -> new ModelMapper().map(notaFiscal, NotaFiscalDto.class))
            .collect(Collectors.toList());
    }
}
