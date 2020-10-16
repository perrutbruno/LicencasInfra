package br.com.alterdata.notafiscalms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.notafiscalms.dto.NotaFiscalDto;
import br.com.alterdata.notafiscalms.dto.Produto;
import br.com.alterdata.notafiscalms.model.NotaFiscal;
import br.com.alterdata.notafiscalms.repository.NotaFiscalRepositorio;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {
    @Autowired
    private NotaFiscalRepositorio repoNotaFiscal;

    @Override
    public NotaFiscalDto cadastrarNotaFiscal(NotaFiscalDto notaFiscal) {
        return salvarNotaFiscal(notaFiscal);
    }

    private NotaFiscalDto salvarNotaFiscal(NotaFiscalDto notaFiscal) {
        ModelMapper mapper = new ModelMapper();

        NotaFiscal NotaFiscalEntidade = mapper.map(notaFiscal, NotaFiscal.class);
        NotaFiscalEntidade = repoNotaFiscal.save(NotaFiscalEntidade);

        return mapper.map(NotaFiscalEntidade, NotaFiscalDto.class);
    }

    @Override
    public List<NotaFiscalDto> obterTodos() {
        List<NotaFiscal> notasFiscais = repoNotaFiscal.findAll();

        return notasFiscais.stream().map(notaFiscal -> new ModelMapper().map(notaFiscal, NotaFiscalDto.class))
                .collect(Collectors.toList());
    }

  
    public List<Integer> obterIdsDosProdutos(Integer idNota) {
        NotaFiscal nf = (NotaFiscal) repoNotaFiscal.findByIdNotaFiscal(idNota);

        List<Integer> idsProdutos = nf.getItens().stream()
        .map(itemNf -> itemNf.getIdProdutos())
        .collect(Collectors.toList());

        return idsProdutos;
    }

/*
    public class NotaFiscalServiceImpl {
    public List<Integer> obterIdsDosProdutos(Integer idNota) {
        //Vai no repositório de Nota Fiscal e pega os itens desta nota (idNota)
        //NotaFiscal nf = repo.findById(idNota).get();
        //Com esses itens, faz o seguinte:
        NotaFiscal nf = new NotaFiscal(); //no teu código, esta nf vai vir do repositório

        List<Integer> idsProdutos = nf.getItens().stream()
        .map(itemNf -> itemNf.getIdProduto())
        .collect(Collectors.toList());

        return idsProdutos;//Esses ids de produto, mando pro Microsserviço de Produtos
    }

    //Lá no Microsserviço de produtos, você vai ter algo assim
    // no teu repositório List<Produto> findByIdIn(List<Integer> ids);

    //No teu service, tu vai chamar esse método passando como parâmetro a lista de ids que recebeu no endpoint
    */
}
