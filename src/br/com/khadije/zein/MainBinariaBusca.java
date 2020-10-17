package br.com.khadije.zein;

import br.com.khadije.zein.domain.ArvoreBinariaBusca;

public class MainBinariaBusca {
	  public static void main(String[] args) {
		  ArvoreBinariaBusca abb = new ArvoreBinariaBusca();
		  abb.insere(5);
		  abb.insere(30);
		  abb.insere(20);
		  abb.insere(10);
		  abb.inOrdem();
		  System.out.println("");
		  abb.preOrdem();
		  System.out.println("");
		  abb.posOrdem();
		  System.out.println("");
		  System.out.println(abb.busca(5).getInfo());
		  System.out.println("");
		  abb.remove(7);
		  System.out.println("");
		  abb.inOrdem();
	  }

}


