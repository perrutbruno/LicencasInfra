package br.com.alterdata.usuarioms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alterdata.usuarioms.dto.UsuarioDto;
import br.com.alterdata.usuarioms.service.UsuarioService;
import br.com.alterdata.usuarioms.view.model.UsuarioModeloResponse;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioModeloResponse> criarUsuario(@RequestBody @Valid UsuarioModeloResponse usuarios) {
        ModelMapper mapper = new ModelMapper();
        UsuarioDto dto = mapper.map(usuarios, UsuarioDto.class);
        dto = service.cadastrarUsuario(dto);
        return new ResponseEntity<>(mapper.map(dto, UsuarioModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModeloResponse>> obterTodos() {
        List<UsuarioDto> dtos = service.obterTodos();

        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<UsuarioModeloResponse> resp = dtos.stream().map(dto -> mapper.map(dto, UsuarioModeloResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/nome/{usuario}")
    public ResponseEntity<List<UsuarioModeloResponse>> obterPorNome(@PathVariable String usuario) {
        Optional<UsuarioDto> dtos = service.obterPorNome(usuario);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<UsuarioModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, UsuarioModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UsuarioModeloResponse> obterPorId(@PathVariable Integer id) {
        Optional<UsuarioDto> usuario = service.obterPorId(id);

        if(usuario.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(usuario.get(), UsuarioModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<Void> desativarUsuario(@PathVariable Integer id) {
        if(service.desativarUsuario(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
