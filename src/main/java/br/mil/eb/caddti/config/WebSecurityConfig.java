package br.mil.eb.caddti.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Value("${ldap.domain}")
//    private String DOMAIN;
//
//    @Value("${ldap.url}")
//    private String URL;
//
//    @Value("${http.port}")
//    private int httpPort;
//
//    @Value("${https.port}")
//    private int httpsPort;

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/layout/**")
			.antMatchers("/stylesheets/**")
		    .antMatchers("/javascripts/**");
			
	}
	
	

	@Override
	protected void configure(HttpSecurity http ) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/home").permitAll()
				.antMatchers("/usuario/novo").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.and()
			.exceptionHandling()
				.accessDeniedPage("/403")
				.and()
			.sessionManagement()
				.invalidSessionUrl("/login")
				.and()
		 
			.csrf().disable();
	}
	
	
//	 @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 
//           auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider()).userDetailsService(userDetailsService());
//          
//	
//          
//     }

     @Bean
     public AuthenticationManager authenticationManager() {
          return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
     }
     
     
     @Bean
     public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
          ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider("7rm.eb.mil.br", "ldap://10.47.21.17:389");
          provider.setConvertSubErrorCodesToExceptions(true);
          provider.setUseAuthenticationRequestCredentials(true);
          return provider;
     }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.inMemoryAuthentication()
				.withUser("admin")
				.password("123")
				.roles("USER");
		
//		contextSource().setUserDn("cn=admin,dc=example,dc=com");
//		contextSource().setPassword("123");
		
		auth
			.ldapAuthentication()
			.userSearchFilter("(samaccountname={0})")
				.groupSearchBase("ou=Groups")
//				.groupRoleAttribute("title")
				
				.contextSource(contextSource())
				.passwordCompare()
					.passwordEncoder(new LdapShaPasswordEncoder())
					.passwordAttribute("userPassword");
	}

	@Bean
	public DefaultSpringSecurityContextSource contextSource() {
		DefaultSpringSecurityContextSource context = new DefaultSpringSecurityContextSource(Arrays.asList("ldap://10.47.21.17:389"), "dn=root,dc=7rm,dc=eb,dc=mil,dc=br"); 
		
		context.setUserDn("cn=Administrator,dc=7rm,dc");
		context.setPassword("XSX2qiGKM3");
//		
		return  context;
	}*/
	
	

}