package br.com.khadije.zein;

import br.com.khadije.zein.domain.ArvoreVermelhoPreta;

public class MainVermelhoPreto {
	public static void main(String[] args) {
		  ArvoreVermelhoPreta rbb = new ArvoreVermelhoPreta();
		  rbb.insere(5);
		  rbb.insere(30);
		  rbb.insere(20);
		  rbb.insere(10);
		  rbb.inOrdem();
		  System.out.println("");
		  rbb.preOrdem();
		  System.out.println("");
		  rbb.posOrdem();
		  System.out.println("");
		  System.out.println(rbb.busca(5).getInfo());
		  System.out.println("");
		  rbb.remove(7);
		  System.out.println("");
	  }
}
