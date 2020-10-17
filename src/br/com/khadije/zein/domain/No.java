package br.com.khadije.zein.domain;

public class No {
	private Integer info;
	private No esquerda;
	private No direita;
	
	public No(Integer info) {
		this.info = info;
		this.esquerda = null;
		this.direita = null;
	}
	
	public Integer getInfo() {
		return info;
	}
	public void setInfo(Integer info) {
		this.info = info;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}
	
	
}
