package br.com.rd.ved.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>, CrudRepository<Pedido,Integer>{

	 List<Pedido> findByClienteId(Integer idCliente);

	void save(Cliente cliente);
	
	@Query(value = " select * from pedido ORDER BY id_pedido DESC LIMIT 1", nativeQuery = true)
	Optional<Pedido> ultimoPedido();	 
}
