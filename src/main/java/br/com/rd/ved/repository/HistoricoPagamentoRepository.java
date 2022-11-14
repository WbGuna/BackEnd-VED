package br.com.rd.ved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.rd.ved.model.HistoricoPagamento;
import br.com.rd.ved.model.Pedido;

public interface HistoricoPagamentoRepository extends JpaRepository<HistoricoPagamento, Integer>, CrudRepository<HistoricoPagamento,Integer>{

	void save(Pedido pedido);


}
