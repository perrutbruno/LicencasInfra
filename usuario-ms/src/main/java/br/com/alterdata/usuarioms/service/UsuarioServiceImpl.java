package br.com.alterdata.usuarioms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.alterdata.usuarioms.dto.UsuarioDto;
import br.com.alterdata.usuarioms.model.Usuario;
import br.com.alterdata.usuarioms.repository.UsuarioRepositorio;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepositorio repoUsuario;

    @Override
    public UsuarioDto cadastrarUsuario(UsuarioDto usuario) {
        usuario.setAtivo(1);
        return salvarUsuario(usuario);
    }

    private UsuarioDto salvarUsuario(UsuarioDto usuario) {
        ModelMapper mapper = new ModelMapper();

        Usuario usuarioEntidade = mapper.map(usuario, Usuario.class);
        usuarioEntidade = repoUsuario.save(usuarioEntidade);

        return mapper.map(usuarioEntidade, UsuarioDto.class);
    }

    @Override
    public List<UsuarioDto> obterTodos() {
        List<Usuario> usuarios = repoUsuario.findAll();

        return usuarios.stream()
            .map(usuario -> new ModelMapper().map(usuario, UsuarioDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDto> obterPorNome(String nomeUsuario) {
        Optional<Usuario> usuario = repoUsuario.findByNome(nomeUsuario);
        if(usuario.isPresent()) {
            return Optional.of(new ModelMapper().map(usuario.get(), UsuarioDto.class));
        }
 
        return Optional.empty();
    }

    @Override
    public Optional<UsuarioDto> obterPorId(Integer id) {
        Optional<Usuario> usuario = repoUsuario.findById(id);

        if(usuario.isPresent()) {
            return Optional.of(new ModelMapper().map(usuario.get(), UsuarioDto.class));
        }
 
        return Optional.empty();
    }

    @Override
    public boolean desativarUsuario(Integer id) {
        Optional<Usuario> usuario = repoUsuario.findById(id);
        if(usuario.isPresent()) {
            usuario.get().setAtivo(0);
            repoUsuario.save(usuario.get());

            return true;
        }

        return false;
    }
}
