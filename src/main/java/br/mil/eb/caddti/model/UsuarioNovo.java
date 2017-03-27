package br.mil.eb.caddti.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="usuario_novo")
public class UsuarioNovo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(name="posto_grad")
	@Enumerated(EnumType.STRING)
	@NotNull(message="Escolha um Posto/Grad!")
	private PostoGrad postoGrad;
	
	@Column(name="nome_guerra")
	@NotBlank(message="Nome de Guerra não pode estar em branco!")
	private String nomeGuerra;
	@NotBlank(message="Nome não pode estar em branco!")
	private String nome;
	@NotBlank(message="Escalão não pode estar em branco!")
	private String escalao;
	@NotBlank(message="Senha não pode estar em branco!")
	private String senha;
	
	@Transient
	private String confirmacaoSenha;
	
	@Size(min = 1, message = "Selecione pelo menos um serviço!")
	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "usuario_servico", uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuario", "servico" }) }, joinColumns = @JoinColumn(name = "usuario"))
	@Column(name = "servico", length = 50)
	private Set<String> servicos = new HashSet<>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public PostoGrad getPostoGrad() {
		return postoGrad;
	}

	public void setPostoGrad(PostoGrad postoGrad) {
		this.postoGrad = postoGrad;
	}

	public String getNomeGuerra() {
		return nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEscalao() {
		return escalao;
	}

	public void setEscalao(String escalao) {
		this.escalao = escalao;
	}


	public Set<String> getServicos() {
		return servicos;
	}

	public void setServicos(Set<String> servicos) {
		this.servicos = servicos;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioNovo other = (UsuarioNovo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
}
