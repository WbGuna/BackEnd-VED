package br.com.rd.ved.formdto;

import br.com.rd.ved.model.NotaFiscal;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Serie;
import br.com.rd.ved.repository.NotaFiscalRepository;

public class NotaFiscalForm {
	private String chave; 
	private Pedido pedido;
	private Serie serie;
	
	public NotaFiscalForm( Pedido pedido) {
		this.pedido = pedido;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public String getChave() {
		return chave;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Serie getSerie() {
		return serie;
	} 
	 
	
	public NotaFiscal converter(NotaFiscalRepository notaRepository) {
		return new NotaFiscal(chave, serie, pedido);
	}
	
	
	
}
