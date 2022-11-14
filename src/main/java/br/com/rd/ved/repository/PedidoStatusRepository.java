package br.com.rd.ved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.PedidoStatus;

@Repository
public interface PedidoStatusRepository extends JpaRepository<PedidoStatus, Integer>,  CrudRepository<PedidoStatus,Integer>{

	PedidoStatus findByDescricao(String descricao);
}
