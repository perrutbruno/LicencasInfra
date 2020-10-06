package br.com.alterdata.fornecedorms.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alterdata.fornecedorms.dto.FornecedorDto;
import br.com.alterdata.fornecedorms.service.FornecedorService;
import br.com.alterdata.fornecedorms.view.model.FornecedorModeloResponse;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @PostMapping
    public ResponseEntity<FornecedorModeloResponse> criarFornecedor(@RequestBody @Valid FornecedorModeloResponse fornecedor) {
        ModelMapper mapper = new ModelMapper();
        FornecedorDto dto = mapper.map(fornecedor, FornecedorDto.class);
        dto = service.cadastrarFornecedor(dto);
        return new ResponseEntity<>(mapper.map(dto, FornecedorModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModeloResponse>> obterTodos() {
        List<FornecedorDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<FornecedorModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, FornecedorModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
