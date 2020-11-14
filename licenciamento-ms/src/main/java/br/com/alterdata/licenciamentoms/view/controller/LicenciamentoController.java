package br.com.alterdata.licenciamentoms.view.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alterdata.licenciamentoms.dto.LicenciamentoDto;
import br.com.alterdata.licenciamentoms.service.LicenciamentoService;
import br.com.alterdata.licenciamentoms.view.model.LicenciamentoModeloResponse;

@RestController
@RequestMapping("/api/licenciamentos")
public class LicenciamentoController {
    @Autowired
    private LicenciamentoService service;

    @PostMapping
    public ResponseEntity<LicenciamentoModeloResponse> criarLicenciamento(@RequestBody @Valid LicenciamentoModeloResponse licenciamento) {
        ModelMapper mapper = new ModelMapper();
        LicenciamentoDto dto = mapper.map(licenciamento, LicenciamentoDto.class);
        dto = service.cadastrarLicenciamento(dto);
        return new ResponseEntity<>(mapper.map(dto, LicenciamentoModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LicenciamentoModeloResponse>> obterTodos() {
        List<LicenciamentoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<LicenciamentoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, LicenciamentoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/{idlicenciamento}")
    public ResponseEntity<List<LicenciamentoModeloResponse>> obterProdutosNotaFiscal(@RequestBody @Valid LicenciamentoModeloResponse licenciamento, @PathVariable List<Integer> idlicenciamento) {
        List<LicenciamentoDto> dtos = service.obterProdutosNotaFiscal(idlicenciamento);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<LicenciamentoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, LicenciamentoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
