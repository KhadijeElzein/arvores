package br.com.khadije.zein.domain;

public class ArvoreBinariaBusca {
	private No raiz;
	
	
	public ArvoreBinariaBusca() {
		super();
		this.raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	public Boolean vazia(No raiz) {
		return (raiz==null);
	}
	
	private void inOrdem(No atual) {
		if(!vazia(atual)) {
			inOrdem(atual.getEsquerda());
			System.out.print(atual.getInfo()+",");
			inOrdem(atual.getDireita());
		}

	}
	
	public void inOrdem() {
		inOrdem(this.raiz);
	}
	
	private void preOrdem(No atual) {
		if(!vazia(atual)) {
			System.out.print(atual.getInfo()+",");
			preOrdem(atual.getEsquerda());
			preOrdem(atual.getDireita());
		}
	}
	public void preOrdem() {
		preOrdem(this.raiz);
	}
	
	private void posOrdem(No atual) {
		if(!vazia(atual)) {
			posOrdem(atual.getEsquerda());
			posOrdem(atual.getDireita());
			System.out.print(atual.getInfo()+",");
		}
	}
	
	public void posOrdem() {
		posOrdem(this.raiz);
	}
	
	private Integer qtdeElementos(No atual) {
		if(!vazia(atual)) {
			return 1+ qtdeElementos(atual.getEsquerda())
			+ qtdeElementos(atual.getDireita());
		}
		else return 0;
	}
	
	public Integer qtdeElementos() {
		return qtdeElementos(this.raiz);
	}
	
	private Integer maior(No atual){
		while(atual.getDireita() != null)
			atual = atual.getDireita();
		return atual.getInfo();
	}
	
	public Integer maior() {
		return maior(this.raiz);
	}
	
	private Integer menor(No atual){
		while(atual.getEsquerda() != null)
			atual = atual.getEsquerda();
		return atual.getInfo();
	}
	
	public Integer menor() {
		return menor(this.raiz);
	}
	
	private Integer somaElementos(No atual) {
		if(!vazia(atual)) {
			return atual.getInfo()+ somaElementos(atual.getEsquerda())
			+ somaElementos(atual.getDireita());
		}
		else return 0;
	}
	
	public Integer somaElementos() {
		return somaElementos(this.raiz);
	}
	
	private No insere(No atual, Integer x){
		if(vazia(atual)) {
			atual = new No(x);
		}
		else if(x < atual.getInfo())
			atual.setEsquerda(insere(atual.getEsquerda(), x)); 
		else 
			atual.setDireita(insere(atual.getDireita(), x));
		return atual;
	}
	
	public void insere(Integer x) {
		this.raiz = insere(this.raiz,x);
	}
	
	private No remove(No atual, Integer x){
		if(vazia(atual))
			return null;
		if(x < atual.getInfo())
			atual.setEsquerda(remove(atual.getEsquerda(),x));
		else if(x > atual.getInfo())
			atual.setDireita(remove(atual.getDireita(),x));
		else 
			if(atual.getEsquerda() == null
			&& atual.getDireita() == null) { 
				atual = null;
			}
		else if(atual.getEsquerda() == null) { 
			atual.setInfo(menor(atual.getDireita()));
			atual.setDireita(remove(atual.getDireita(),atual.getInfo()));
		}
		else { 
			atual.setInfo(maior(atual.getEsquerda()));
			atual.setEsquerda(remove(atual.getEsquerda(),atual.getInfo()));
		}
		return atual;
	}
	
	public void remove(Integer x) {
		this.raiz = remove(this.raiz,x);
	}
	
	private No busca(No atual, Integer x){
		if(vazia(atual))
			return null;
		if(atual.getInfo() > x)
			return busca(atual.getEsquerda(), x);
		if(atual.getInfo() < x)
			return busca(atual.getDireita(), x);
		return atual;
	}
	
	public No busca(Integer x) {
		return busca(this.raiz,x);
	}
	
}
