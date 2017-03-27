package br.mil.eb.caddti.model;

public enum PostoGrad {

	
	GEN("Gen"),
	CEL("Cel"),
	TENCEL("Ten Cel"),
	MAJ("Maj"),
	CAP("Cap"),
	PRIMEIRO_TEN("1º Ten"),
	SEGUNDO_TEN("2º Ten"),
	ASP("Asp Of"),
	SUB_TEN("Sub Ten"),
	PRIMEIRO_SGT("1º Sgt"),
	SEGUNDO_SGT("2º Sgt"),
	TERCEIRO_SGT("3º Sgt"),
	CB("Cb"),
	SD("Sd");
	
	private String descricao;
	
	PostoGrad(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() { 
		return descricao;
	}
	
	
}
