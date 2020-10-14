package br.com.alterdata.produtoms.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alterdata.produtoms.dto.ProdutoDto;
import br.com.alterdata.produtoms.service.ProdutoService;
import br.com.alterdata.produtoms.view.model.ProdutoModeloResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoModeloResponse> criarProduto(@RequestBody @Valid ProdutoModeloResponse produto) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = service.cadastrarProduto(dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModeloResponse>> obterTodos() {
        List<ProdutoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<ProdutoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, ProdutoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/{idproduto}")
    public ResponseEntity<List<ProdutoModeloResponse>> obterProdutosNotaFiscal(@RequestBody @Valid ProdutoModeloResponse produto, @PathVariable List<Integer> idproduto) {
        List<ProdutoDto> dtos = service.obterProdutosNotaFiscal(idproduto);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<ProdutoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, ProdutoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
