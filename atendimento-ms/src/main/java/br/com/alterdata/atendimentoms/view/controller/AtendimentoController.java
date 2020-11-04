package br.com.alterdata.atendimentoms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alterdata.atendimentoms.dto.AtendimentoDto;
import br.com.alterdata.atendimentoms.service.AtendimentoService;
import br.com.alterdata.atendimentoms.view.model.AtendimentoModeloResponse;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {
    @Autowired
    private AtendimentoService service;

    @PostMapping
    public ResponseEntity<AtendimentoModeloResponse> criarAtendimento(@RequestBody @Valid AtendimentoModeloResponse atendimentos) {
        ModelMapper mapper = new ModelMapper();
        AtendimentoDto dto = mapper.map(atendimentos, AtendimentoDto.class);
        dto = service.cadastrarAtendimento(dto);
        return new ResponseEntity<>(mapper.map(dto, AtendimentoModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoModeloResponse>> obterTodos() {
        List<AtendimentoDto> dtos = service.obterTodos();

        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<AtendimentoModeloResponse> resp = dtos.stream().map(dto -> mapper.map(dto, AtendimentoModeloResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/numero/{atendimento}")
    public ResponseEntity<List<AtendimentoModeloResponse>> obterPorNumeroAtendimento(@PathVariable String atendimento) {
        Optional<AtendimentoDto> dtos = service.obterPorNumero(atendimento);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<AtendimentoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, AtendimentoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<AtendimentoModeloResponse> obterPorId(@PathVariable Integer id) {
        Optional<AtendimentoDto> atendimento = service.obterPorId(id);

        if(atendimento.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(atendimento.get(), AtendimentoModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
