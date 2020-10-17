package br.com.khadije.zein.domain;

import br.com.khadije.zein.domain.enums.Cor;

public class ArvoreVermelhoPreta {
	private NoVermelhoPreta raiz;
	
	public ArvoreVermelhoPreta() {
		this.raiz = null;
	}
	public NoVermelhoPreta getRaiz() {
		return raiz;
	}

	public void setRaiz(NoVermelhoPreta raiz) {
		this.raiz = raiz;
	}

	public Cor cor(NoVermelhoPreta atual) {
		if(atual == null) {
			return Cor.PRETO;
		}else {
			return atual.getCor();
		}
	}
	private NoVermelhoPreta recoloracao(NoVermelhoPreta atual) {
		if(atual.getCor().equals(Cor.VERMELHO)) {
			atual.setCor(Cor.PRETO);
		}else if(atual.getCor().equals(Cor.PRETO)) {
			atual.setCor(Cor.VERMELHO);
		}
		if(atual.getEsquerda() != null) {
			if(atual.getEsquerda().getCor().equals(Cor.VERMELHO)) {
				atual.getEsquerda().setCor(Cor.PRETO);
			}else if(atual.getEsquerda().getCor().equals(Cor.PRETO)) {
				atual.getEsquerda().setCor(Cor.VERMELHO);
			}
		}
		if(atual.getDireita() !=null) {
			if(atual.getDireita().getCor().equals(Cor.VERMELHO)) {
				atual.getDireita().setCor(Cor.PRETO);
			}else if(atual.getDireita().getCor().equals(Cor.PRETO)) {
				atual.getEsquerda().setCor(Cor.VERMELHO);
			}
		}
		return atual;
	}
	private NoVermelhoPreta rotacaoEsquerda(NoVermelhoPreta a) {
		NoVermelhoPreta b = a.getDireita();
		a.setDireita(b.getEsquerda());
		b.setEsquerda(a);
		b.setCor(a.getCor());
		a.setCor(Cor.VERMELHO);
		return b;
	}
	private NoVermelhoPreta rotacaoDireita(NoVermelhoPreta a) {
		NoVermelhoPreta b = a.getEsquerda();
		a.setEsquerda(b.getDireita());
		b.setDireita(a);
		b.setCor(a.getCor());
		a.setCor(Cor.VERMELHO);
		return b;
	}
	private NoVermelhoPreta balanceamento(NoVermelhoPreta atual) {
		if(cor(atual.getDireita()).equals(Cor.VERMELHO) 
				&& cor(atual.getEsquerda()).equals(Cor.PRETO)) {
			atual = rotacaoEsquerda(atual);
		}
		if(cor(atual.getEsquerda()).equals(Cor.VERMELHO) 
				&& cor(atual.getEsquerda().getEsquerda()).equals(Cor.VERMELHO)) {
			atual = rotacaoDireita(atual);
		}
		if(cor(atual.getEsquerda()).equals(Cor.VERMELHO) 
				&& cor(atual.getDireita()).equals(Cor.VERMELHO)) {
			atual = recoloracao(atual);
		}
		return atual;
	}
	public NoVermelhoPreta insere(NoVermelhoPreta raiz, Integer x) {
		raiz = insereNo(raiz,x);
		if(raiz!=null) {
			raiz.setCor(Cor.PRETO);
		}
		return raiz;
	}
	private NoVermelhoPreta insereNo(NoVermelhoPreta atual, Integer x) {
		if(atual == null) {
			NoVermelhoPreta novo = new NoVermelhoPreta(x);
			return novo;
		}
		if(x < atual.getInfo()) {
			atual.setEsquerda(insereNo(atual.getEsquerda(),x));
		}else if(x > atual.getInfo()) {
			atual.setDireita(insereNo(atual.getDireita(),x));
		}
		atual = balanceamento(atual);
		return atual;
	}
	public NoVermelhoPreta remove(NoVermelhoPreta raiz, Integer x) {
		if(busca(raiz,x)!=null) {
			NoVermelhoPreta atual = raiz;
			raiz = removeNo(atual,x);
			if(raiz!=null) {
				raiz.setCor(Cor.PRETO);
			}
		}
		return raiz;
	}
	private NoVermelhoPreta busca(NoVermelhoPreta atual, Integer x){
		if(atual == null)
			return null;
		if(atual.getInfo() > x)
			return busca(atual.getEsquerda(), x);
		if(atual.getInfo() < x)
			return busca(atual.getDireita(), x);
		return atual;
	}
	
	private NoVermelhoPreta removeNo(NoVermelhoPreta atual, Integer x) {
		if(x < atual.getInfo()) {
			if(cor(atual.getEsquerda()).equals(Cor.PRETO) && 
					cor(atual.getEsquerda().getEsquerda()).equals(Cor.PRETO)) {
				atual = movePraEsquerdaVermelho(atual);
			}
			atual.setEsquerda(removeNo(atual.getEsquerda(),x));
		}else {
			if(cor(atual.getEsquerda()).equals(Cor.VERMELHO)) {
				atual = rotacaoDireita(atual);
			}
			if(x.equals(atual.getInfo()) && (atual.getDireita() == null) 
					&& (atual.getEsquerda() == null)) {
				return null;
			}
			if(cor(atual.getDireita()).equals(Cor.PRETO) && 
					cor(atual.getDireita().getEsquerda()).equals(Cor.PRETO)) {
				
				atual = movePraDireitaVermelho(atual);
			}
			if(x.equals(atual.getInfo())) {
				NoVermelhoPreta aux = menor(atual.getDireita());
				atual.setInfo(aux.getInfo());
				atual.setDireita(removeMenor(atual.getDireita()));
			}else {
				atual.setDireita(removeNo(atual.getDireita(),x));
			}
		}
		return balanceamento(atual);
	}
	private NoVermelhoPreta movePraEsquerdaVermelho(NoVermelhoPreta atual) {
		atual = recoloracao(atual);
		if(cor(atual.getDireita().getEsquerda()).equals(Cor.VERMELHO)) {
			atual.setDireita(rotacaoDireita(atual.getDireita()));
			atual = rotacaoEsquerda(atual);
			atual = recoloracao(atual);
		}
		return atual;	
	}
	private NoVermelhoPreta movePraDireitaVermelho(NoVermelhoPreta atual) {
		atual = recoloracao(atual);
		if(cor(atual.getEsquerda().getEsquerda()).equals(Cor.VERMELHO)) {
			atual = rotacaoDireita(atual);
			atual = recoloracao(atual);
		}
		return atual;
	}
	private NoVermelhoPreta removeMenor(NoVermelhoPreta atual) {
		if(atual.getEsquerda() == null) {
			return null;
		}
		if(cor(atual.getEsquerda()).equals(Cor.PRETO) && 
				cor(atual.getEsquerda().getEsquerda()).equals(Cor.PRETO)) {
			atual = movePraEsquerdaVermelho(atual);
		}
		atual.setEsquerda(removeMenor(atual.getEsquerda()));
		return balanceamento(atual);
	}
	
	private NoVermelhoPreta menor(NoVermelhoPreta atual) {
		NoVermelhoPreta no1 = atual;
		NoVermelhoPreta no2= atual.getEsquerda();
		while(no2!=null) {
			no1 = no2;
			no2 = no2.getEsquerda();
		}
		return no1;
	}
	
	public void insere(Integer x) {
		this.raiz = insere(this.raiz,x);
	}
	private void inOrdem(NoVermelhoPreta raiz) {
		if(raiz!=null) {
			inOrdem(raiz.getEsquerda());
			System.out.print(raiz.getInfo()+"("+raiz.getCor()+"),");
			inOrdem(raiz.getDireita());
		}

	}
	
	public void inOrdem() {
		inOrdem(this.raiz);
	}
	
	private void preOrdem(NoVermelhoPreta atual) {
		if(atual!=null) {
			System.out.print(atual.getInfo()+"("+atual.getCor()+"),");
			preOrdem(atual.getEsquerda());
			preOrdem(atual.getDireita());
		}
	}
	public void preOrdem() {
		preOrdem(this.raiz);
	}
	private void posOrdem(NoVermelhoPreta atual) {
		if(atual!=null) {
			posOrdem(atual.getEsquerda());
			posOrdem(atual.getDireita());
			System.out.print(atual.getInfo()+"("+atual.getCor()+"),");
		}
	}
	
	public void posOrdem() {
		posOrdem(this.raiz);
	}
	public NoVermelhoPreta busca(Integer x) {
		return busca(this.raiz,x);
	}
	
	public void remove(Integer x) {
		this.raiz = remove(this.raiz,x);
	}
	
}
