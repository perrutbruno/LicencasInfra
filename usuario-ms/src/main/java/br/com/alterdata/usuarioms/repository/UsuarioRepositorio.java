package br.com.alterdata.usuarioms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alterdata.usuarioms.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNome(String nome);
	Optional<Usuario> findById(Integer id);
    
}
