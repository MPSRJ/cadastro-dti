package br.mil.eb.caddti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.eb.caddti.model.UsuarioNovo;
import br.mil.eb.caddti.repository.UsuariosNovos;

@Service
public class CadastroUsuarioNovoService {
	
	@Autowired
	private UsuariosNovos usuaiosNovos;
	
	// @Transactional
	public void salvar(UsuarioNovo usuarioNovo){
		usuaiosNovos.save(usuarioNovo);
		
	}

}
