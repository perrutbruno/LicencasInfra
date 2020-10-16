package br.com.alterdata.chavelicencams.view.controller;

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

import br.com.alterdata.chavelicencams.dto.ChaveLicencaDto;
import br.com.alterdata.chavelicencams.service.ChaveLicencaService;
import br.com.alterdata.chavelicencams.view.model.ChaveLicencaModeloResponse;


@RestController
@RequestMapping("/api/chaves")
public class ChaveLicencaController {
    @Autowired
    private ChaveLicencaService service;

    @PostMapping
    public ResponseEntity<ChaveLicencaModeloResponse> criarFornecedor(@RequestBody @Valid ChaveLicencaModeloResponse chave) {
        ModelMapper mapper = new ModelMapper();
        ChaveLicencaDto dto = mapper.map(chave, ChaveLicencaDto.class);
        dto = service.cadastrarChaveLicenca(dto);
        return new ResponseEntity<>(mapper.map(dto, ChaveLicencaModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChaveLicencaModeloResponse>> obterTodos() {
        List<ChaveLicencaDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<ChaveLicencaModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, ChaveLicencaModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
