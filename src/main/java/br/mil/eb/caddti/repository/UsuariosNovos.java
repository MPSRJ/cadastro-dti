package br.mil.eb.caddti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.caddti.model.UsuarioNovo;

@Repository
public interface UsuariosNovos extends JpaRepository<UsuarioNovo, Long> {

}
