package br.com.khadije.zein.domain;

public class NoAVL {
	private Integer fb; // fator de balanceamento
	private Integer altura; // altura do nó;
	private NoAVL esquerda;
	private NoAVL direita;
	private Integer info;
	public NoAVL(Integer info) {
		this.info = info;
		this.esquerda = null;
		this.direita = null;
		this.fb = 0;
		this.altura = -1;
	}

	public Integer getFb() {
		return fb;
	}

	public void setFb(Integer fb) {
		this.fb = fb;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public NoAVL getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoAVL esquerda) {
		this.esquerda = esquerda;
	}

	public NoAVL getDireita() {
		return direita;
	}

	public void setDireita(NoAVL direita) {
		this.direita = direita;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

}
