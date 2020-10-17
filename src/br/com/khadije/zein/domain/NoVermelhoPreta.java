package br.com.khadije.zein.domain;

import br.com.khadije.zein.domain.enums.Cor;

public class NoVermelhoPreta {
	private NoVermelhoPreta esquerda;
	private NoVermelhoPreta direita;
	private NoVermelhoPreta pai;
	private Integer info;
	private Cor cor;
	
	public NoVermelhoPreta(Integer info) {
		this.info = info;
		this.cor = Cor.VERMELHO;
	}
	
	public NoVermelhoPreta getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(NoVermelhoPreta esquerda) {
		this.esquerda = esquerda;
	}
	public NoVermelhoPreta getDireita() {
		return direita;
	}
	public void setDireita(NoVermelhoPreta direita) {
		this.direita = direita;
	}
	public Integer getInfo() {
		return info;
	}
	public void setInfo(Integer info) {
		this.info = info;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public NoVermelhoPreta getPai() {
		return pai;
	}
	public void setPai(NoVermelhoPreta pai) {
		this.pai = pai;
	} 

	
	

}
