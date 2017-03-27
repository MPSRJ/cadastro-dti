package br.mil.eb.caddti.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.mil.eb.caddti.model.PostoGrad;
import br.mil.eb.caddti.model.Servico;
import br.mil.eb.caddti.model.UsuarioNovo;
import br.mil.eb.caddti.service.CadastroUsuarioNovoService;

@Controller
public class HomeController {
	
	@Autowired
	private CadastroUsuarioNovoService cadastroUsuarioNovoService;
	
	
	
	@RequestMapping("/")
	public ModelAndView inicio(UsuarioNovo usuarioNovo){
		ModelAndView mv = new ModelAndView("home-page");
		
		mv.addObject("postoGrads", PostoGrad.values());
		mv.addObject("servicos", Servico.values());
		
		
		return mv;
	}
	
	@PostMapping("/usuarionovo")
	public ModelAndView salvar(@Valid UsuarioNovo usuarioNovo, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()) {
			
			return inicio(usuarioNovo);
		}
		
		cadastroUsuarioNovoService.salvar(usuarioNovo);
		
		
		
		attributes.addFlashAttribute("mensagem", String.format( "Usuário - %s %s - salvo com sucesso!",
				usuarioNovo.getPostoGrad().getDescricao(), usuarioNovo.getNomeGuerra()));
		
		
		return new ModelAndView("redirect:/");	
	}

}
