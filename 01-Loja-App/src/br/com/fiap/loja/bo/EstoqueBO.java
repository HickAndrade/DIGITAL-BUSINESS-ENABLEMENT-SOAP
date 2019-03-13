package br.com.fiap.loja.bo;


import org.apache.log4j.Logger;


import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	private static Logger log = Logger.getLogger(EstoqueBO.class);
	
	public static ProdutoTO consultaBO(int codProd) {
		
		
		if (codProd == 401) {
			log.debug(codProd + " - " + " Camisa Branca");
			return new ProdutoTO(codProd,2.99,4, "Camisa Branca");
		
		} else if (codProd == 402) {
			log.debug(codProd + " - " + " Camisa Azul");
			return new ProdutoTO(codProd,2.99,4, "Camisa Azul");
			// System.out.println( p.getDescricao());
		} else if (codProd == 403) {
			log.debug(codProd + " - " + " Camisa Rosa");
			return new ProdutoTO(codProd,2.99,4, "Camisa Rosa");
		} else {
			log.error(codProd + " - " + "Produto não encontrado");
			return new ProdutoTO(-1,0,0, "Produto não encontrado");
		}
	}

}
