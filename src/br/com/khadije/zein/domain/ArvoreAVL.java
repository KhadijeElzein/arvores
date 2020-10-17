package br.com.khadije.zein.domain;

public class ArvoreAVL {
	private NoAVL raiz;
	
	
	public ArvoreAVL() {
		super();
		this.setRaiz(null);
	}


	public NoAVL getRaiz() {
		return raiz;
	}


	public void setRaiz(NoAVL raiz) {
		this.raiz = raiz;
	}
	
	
	public Integer max(Integer a, Integer b) { 
        return (a > b) ? a : b; 
    } 
	public Integer altura(NoAVL raiz) {
		if (raiz == null) 
			return -1;
		else 
			return raiz.getAltura();
	}
	
	private Integer calcularFb(NoAVL no) {
		return altura(no.getEsquerda())-altura(no.getDireita());
	}
	
	public NoAVL rotacaoDireita(NoAVL a) {
		NoAVL b = a.getEsquerda();
		a.setEsquerda(b.getDireita());
		b.setDireita(a);
		a.setAltura(max(altura(a.getEsquerda()),
				altura(a.getDireita()))+1);
		b.setAltura(max(altura(b.getEsquerda()),
				a.getAltura())+1);
		a.setFb(calcularFb(a));
	    b.setFb(calcularFb(b));
		return b;
	}
	
	public NoAVL rotacaoEsquerda(NoAVL a) {
		NoAVL b = a.getDireita();
		a.setDireita(b.getEsquerda());
	    b.setEsquerda(a);
		a.setAltura(max(altura(a.getEsquerda()),
				altura(a.getDireita()))+1);
		b.setAltura(max(altura(b.getDireita()),
			a.getAltura()) + 1);
		a.setFb(calcularFb(a));
	    b.setFb(calcularFb(b));
		return b;
	 }
	
	public NoAVL rotacaoEsquerdaDireita(NoAVL a) {
		a.setEsquerda(rotacaoEsquerda(a.getEsquerda()));
		return rotacaoDireita(a);
	}
	
	public NoAVL rotacaoDireitaEsquerda(NoAVL a) {
		a.setDireita(rotacaoDireita(a.getDireita()));
		return rotacaoEsquerda(a);
	}
	
	public NoAVL balanceamento(NoAVL no,Integer x) {
		if(no.getFb().equals(-2)) {
			if(x>no.getDireita().getInfo())
				return rotacaoEsquerda(no);
			else return rotacaoDireitaEsquerda(no);
		}else if(no.getFb().equals(2)) {
			if(x<no.getEsquerda().getInfo()) 
				return rotacaoDireita(no);
			else return rotacaoEsquerdaDireita(no);
		}
		return no;
	}
	
	private NoAVL insere(NoAVL raiz, Integer x) {
		if(raiz == null) {
			raiz = new NoAVL(x);
		}
		else if(x > raiz.getInfo())
			raiz.setDireita(insere(raiz.getDireita(),x));
		else if(x < raiz.getInfo())
		 raiz.setEsquerda(insere(raiz.getEsquerda(),x));
		raiz.setAltura(max(altura(raiz.getEsquerda()),altura(raiz.getDireita()))+1);
		raiz.setFb(calcularFb(raiz));
		raiz = balanceamento(raiz, x);
		return raiz;
	}
	
	public Integer menor(NoAVL atual){
		while(atual.getEsquerda() != null)
			atual = atual.getEsquerda();
		return atual.getInfo();
	}
	
	public Integer maior(NoAVL atual){
		while(atual.getDireita() != null)
			atual = atual.getDireita();
		return atual.getInfo();
	}
	
	public NoAVL remove(NoAVL atual, Integer x){
		if(atual == null)
			return null;
		if(x < atual.getInfo())
			atual.setEsquerda(remove(atual.getEsquerda(),x));
		else if(x > atual.getInfo())
			atual.setDireita(remove(atual.getDireita(),x));
		else 
			if(atual.getEsquerda() == null
			&& atual.getDireita() == null) { 
				atual = null;
				return atual;
			}
		else if(atual.getEsquerda() == null) { 
			atual.setInfo(menor(atual.getDireita()));
			atual.setDireita(remove(atual.getDireita(),atual.getInfo()));
		}
		else { 
			atual.setInfo(maior(atual.getEsquerda()));
			atual.setEsquerda(remove(atual.getEsquerda(),atual.getInfo()));
		}
		atual.setAltura(max(altura(atual.getEsquerda()),altura(atual.getDireita()))+1);
		atual.setFb(calcularFb(atual));
		atual = balanceamento(atual, x);
		return atual;
	}
	
	public NoAVL busca(NoAVL atual, Integer x){
		if(atual == null)
			return null;
		if(atual.getInfo() > x)
			return busca(atual.getEsquerda(), x);
		if(atual.getInfo() < x)
			return busca(atual.getDireita(), x);
		return atual;
	}
	public void insere(Integer x) {
		this.raiz = insere(this.raiz,x);
	}
	private void inOrdem(NoAVL raiz) {
		if(raiz!=null) {
			inOrdem(raiz.getEsquerda());
			System.out.print(raiz.getInfo()+",");
			inOrdem(raiz.getDireita());
		}

	}
	
	public void inOrdem() {
		inOrdem(this.raiz);
	}
	
	private void preOrdem(NoAVL atual) {
		if(atual!=null) {
			System.out.print(atual.getInfo()+",");
			preOrdem(atual.getEsquerda());
			preOrdem(atual.getDireita());
		}
	}
	public void preOrdem() {
		preOrdem(this.raiz);
	}
	private void posOrdem(NoAVL atual) {
		if(atual!=null) {
			posOrdem(atual.getEsquerda());
			posOrdem(atual.getDireita());
			System.out.print(atual.getInfo()+",");
		}
	}
	
	public void posOrdem() {
		posOrdem(this.raiz);
	}
	public NoAVL busca(Integer x) {
		return busca(this.raiz,x);
	}
	
	public void remove(Integer x) {
		this.raiz = remove(this.raiz,x);
	}
	public Integer altura() {
		return altura(this.raiz);
	}
}
