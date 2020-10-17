package br.com.khadije.zein;

import br.com.khadije.zein.domain.ArvoreAVL;

public class MainAVL {
	 public static void main(String[] args) {
		  ArvoreAVL avl = new ArvoreAVL();
		  avl.insere(5);
		  avl.insere(30);
		  avl.insere(20);
		  avl.insere(10);
		  System.out.println("Altura:"+avl.altura());
		  avl.inOrdem();
		  System.out.println("");
		  avl.preOrdem();
		  System.out.println("");
		  avl.posOrdem();
		  System.out.println("");
		  System.out.println(avl.busca(5).getInfo());
		  System.out.println("");
		  avl.remove(7);
		  System.out.println("");
		  avl.inOrdem();
	  }
}
