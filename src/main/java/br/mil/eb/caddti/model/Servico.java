package br.mil.eb.caddti.model;

public enum Servico {
	
	REDE("Rede"),
	SPED("SPED"),
	SISBOL("SisBol"),
	INTERNET("Internet");
	
	private String descricao;
	
	Servico(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	
}
