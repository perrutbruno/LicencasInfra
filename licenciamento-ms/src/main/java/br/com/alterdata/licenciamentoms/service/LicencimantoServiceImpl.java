package br.com.alterdata.licenciamentoms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.licenciamentoms.dto.LicenciamentoDto;
import br.com.alterdata.licenciamentoms.model.Licenciamento;
import br.com.alterdata.licenciamentoms.repository.LicenciamentoRepositorio;

@Service
public class LicencimantoServiceImpl implements LicenciamentoService {
    @Autowired
    private LicenciamentoRepositorio repoLicenciamento;

    @Override
    public LicenciamentoDto cadastrarLicenciamento(LicenciamentoDto licenciamento) {
        return salvarLicenciamento(licenciamento);
    }

    private LicenciamentoDto salvarLicenciamento(LicenciamentoDto licenciamento) {
        ModelMapper mapper = new ModelMapper();

        Licenciamento licenciamentoEntidade = mapper.map(licenciamento, Licenciamento.class);
        licenciamentoEntidade = repoLicenciamento.save(licenciamentoEntidade);

        return mapper.map(licenciamentoEntidade, LicenciamentoDto.class);
    }

    @Override
    public List<LicenciamentoDto> obterTodos() {
        List<Licenciamento> licenciamentos = repoLicenciamento.findAll();

        return licenciamentos.stream()
            .map(licenciamento -> new ModelMapper().map(licenciamento, LicenciamentoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<LicenciamentoDto> obterProdutosNotaFiscal(List<Integer> id) {
        List<Licenciamento> produtos = repoLicenciamento.findAllById(id);

        return produtos.stream()
            .map(produto -> new ModelMapper().map(produto, LicenciamentoDto.class))
            .collect(Collectors.toList());
    }
}
