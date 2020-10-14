package br.com.alterdata.notafiscalms.view.controller;

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

import br.com.alterdata.notafiscalms.dto.NotaFiscalDto;
import br.com.alterdata.notafiscalms.service.NotaFiscalService;
import br.com.alterdata.notafiscalms.view.model.NotaFiscalModeloResponse;

@RestController
@RequestMapping("/api/notafiscal")
public class NotaFiscalController {
    @Autowired
    private NotaFiscalService service;

    @PostMapping
    public ResponseEntity<NotaFiscalModeloResponse> criarNotaFiscal(@RequestBody @Valid NotaFiscalModeloResponse produto) {
        ModelMapper mapper = new ModelMapper();
        NotaFiscalDto dto = mapper.map(produto, NotaFiscalDto.class);
        dto = service.cadastrarNotaFiscal(dto);
        return new ResponseEntity<>(mapper.map(dto, NotaFiscalModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NotaFiscalModeloResponse>> obterTodos() {
        List<NotaFiscalDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<NotaFiscalModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, NotaFiscalModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    

    
}
