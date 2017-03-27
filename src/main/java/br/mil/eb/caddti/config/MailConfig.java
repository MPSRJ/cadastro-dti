package br.mil.eb.caddti.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.mil.eb.caddti.mail.Mailer;



@Configuration
@ComponentScan(basePackageClasses = Mailer.class)
public class MailConfig {
	
	

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("10.47.23.80");
		mailSender.setPort(25);
		mailSender.setUsername("ponciano");
		mailSender.setPassword("065978");
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
	//	props.put("mail.smtp.starttls.enable", true);
		props.put("mail.debug", false);
		props.put("mail.smtp.connectiontimeout", 10000); // miliseconds

		mailSender.setJavaMailProperties(props);
		
		return mailSender;
	}
	
}
