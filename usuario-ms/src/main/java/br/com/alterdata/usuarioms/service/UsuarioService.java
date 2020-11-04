package br.com.alterdata.usuarioms.service;

import java.util.List;
import java.util.Optional;

import br.com.alterdata.usuarioms.dto.UsuarioDto;

public interface UsuarioService {
    UsuarioDto cadastrarUsuario(UsuarioDto dto);
    List<UsuarioDto> obterTodos();
    Optional<UsuarioDto> obterPorNome(String nome);
    Optional<UsuarioDto> obterPorId(Integer id);
    boolean desativarUsuario(Integer id);
}
