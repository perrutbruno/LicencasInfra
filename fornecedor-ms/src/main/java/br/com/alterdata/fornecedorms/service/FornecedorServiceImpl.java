package br.com.alterdata.fornecedorms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.criterion.Example;
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
        fornecedor.setAtivo(1);
        return salvarFornecedor(fornecedor);
    }

    private FornecedorDto salvarFornecedor(FornecedorDto fornecedor) {
        ModelMapper mapper = new ModelMapper();

        Fornecedor fornecedorEntidade = mapper.map(fornecedor, Fornecedor.class);
        fornecedorEntidade = repoFornecedor.save(fornecedorEntidade);

        return mapper.map(fornecedorEntidade, FornecedorDto.class);
    }


    @Override
    public FornecedorDto alterarFornecedor(Integer id, FornecedorDto fornecedor) {
        fornecedor.setIdFornecedor(id);
        return salvarFornecedor(fornecedor);
    }

    @Override
    public List<FornecedorDto> obterTodos() {
        List<Fornecedor> fornecedores = repoFornecedor.findAll();

        return fornecedores.stream()
            .map(fornecedor -> new ModelMapper().map(fornecedor, FornecedorDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Fornecedor obterPorId(Integer id, FornecedorDto fornecedor) {
        Fornecedor fornecedores = repoFornecedor.getOne(id);

        return fornecedores;
    }

    @Override
    public Optional<FornecedorDto> obterPorNome(String nomeFornecedor) {
        Optional<Fornecedor> setor = repoFornecedor.findByNomeFornecedor(nomeFornecedor);
        if(setor.isPresent()) {
            return Optional.of(new ModelMapper().map(setor.get(), FornecedorDto.class));
        }
 
        return Optional.empty();
    }
}
