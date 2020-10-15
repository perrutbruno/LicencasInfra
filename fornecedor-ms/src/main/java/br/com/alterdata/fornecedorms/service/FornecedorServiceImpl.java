package br.com.alterdata.fornecedorms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.fornecedorms.dto.FornecedorDto;
import br.com.alterdata.fornecedorms.model.Fornecedor;
import br.com.alterdata.fornecedorms.repository.FornecedorRepositorio;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    @Autowired
    private FornecedorRepositorio repoFornecedor;

    @Override
    public FornecedorDto cadastrarFornecedor(FornecedorDto fornecedor) {
        return salvarFornecedor(fornecedor);
    }

    private FornecedorDto salvarFornecedor(FornecedorDto fornecedor) {
        ModelMapper mapper = new ModelMapper();

        Fornecedor fornecedorEntidade = mapper.map(fornecedor, Fornecedor.class);
        fornecedorEntidade = repoFornecedor.save(fornecedorEntidade);

        return mapper.map(fornecedorEntidade, FornecedorDto.class);
    }

    @Override
    public List<FornecedorDto> obterTodos() {
        List<Fornecedor> fornecedores = repoFornecedor.findAll();

        return fornecedores.stream()
            .map(fornecedor -> new ModelMapper().map(fornecedor, FornecedorDto.class))
            .collect(Collectors.toList());
    }
}
