package br.com.alterdata.setorms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alterdata.setorms.dto.SetorDto;
import br.com.alterdata.setorms.model.Setor;
import br.com.alterdata.setorms.service.SetorService;
import br.com.alterdata.setorms.view.model.SetorModeloResponse;

@RestController
@RequestMapping("/api/setores")
public class SetorController {
    @Autowired
    private SetorService service;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<SetorModeloResponse> criarSetor(@RequestBody @Valid SetorModeloResponse setores) {
        ModelMapper mapper = new ModelMapper();
        SetorDto dto = mapper.map(setores, SetorDto.class);
        dto = service.cadastrarSetor(dto);
        return new ResponseEntity<>(mapper.map(dto, SetorModeloResponse.class), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<SetorModeloResponse>> obterTodos() {
        List<SetorDto> dtos = service.obterTodos();

        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<SetorModeloResponse> resp = dtos.stream().map(dto -> mapper.map(dto, SetorModeloResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/nome/{setor}")
    public ResponseEntity<List<SetorModeloResponse>> obterPorNome(@PathVariable String setor) {
        Optional<SetorDto> dtos = service.obterPorNome(setor);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<SetorModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, SetorModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value="/{id}")
    public ResponseEntity<SetorModeloResponse> obterPorId(@PathVariable Integer id) {
        Optional<SetorDto> setor = service.obterPorId(id);

        if(setor.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(setor.get(), SetorModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin
    @PutMapping(value="/{id}")
    public ResponseEntity<Setor> atualizarSetor(@PathVariable Integer id, @RequestBody Setor setor) {
        return new ResponseEntity<>(service.atualizaSetor(id, setor), HttpStatus.OK);
        
    }

    @CrossOrigin
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerSetor(@PathVariable Integer id) {
        service.removerSetor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }   
}
