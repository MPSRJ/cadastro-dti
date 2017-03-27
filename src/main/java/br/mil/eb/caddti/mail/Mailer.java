package br.mil.eb.caddti.mail;

import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.mil.eb.caddti.model.UsuarioNovo;

@Component
public class Mailer {
	
	private static Logger logger = LoggerFactory.getLogger(Mailer.class);

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TemplateEngine thymeleaf;
	
	@Async
	public void enviar(UsuarioNovo usuarioNovo) {
		Context context = new Context(new Locale("pt", "BR"));
		
		context.setVariable("usuarioNovo", usuarioNovo);
		context.setVariable("logo", "logo");
		
				
		try {
			String email = thymeleaf.process("mail/CorpoEmail", context);
			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setFrom("sistema-cadastro@7rm.eb.mil.br");
			helper.setTo("ti@7rm.eb.mil.br");
			helper.setSubject(String.format("DTI - Novo Usuário %s %s", usuarioNovo.getPostoGrad().getDescricao(), usuarioNovo.getNomeGuerra()));
			helper.setText(email, true);
			
			helper.addInline("logo", new ClassPathResource("static/images/logo.png"));
					
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			logger.error("Erro enviando e-mail", e);
		}
	}
	
}
