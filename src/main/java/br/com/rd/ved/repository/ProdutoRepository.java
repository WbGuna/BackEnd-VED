package br.com.rd.ved.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>, CrudRepository<Produto, Integer> {


	@Query(value = "select * from produto p inner join categoria c on p.id_categoria = c.id_categoria"
			+ " where c.descricao_categoria = :categoria order by id_produto desc limit 4 ", nativeQuery = true)
	List<Produto> findProdutosPorCategoria(@Param("categoria") String categoria);

	@Query(value = "select * from produto p order by p.id_produto desc limit 8", nativeQuery = true)
	List<Produto> findNovidades();
	
	@Query(value = "select * from produto p   where p.id_categoria != 5 order by  p.preco  desc limit 8", nativeQuery = true)
	List<Produto> findOfertas();

	@Query(value = " select * from produto where preco <= :valor", nativeQuery = true)
	List<Produto> findProdutosPorValor(@Param("valor") Integer valor);

	@Query(value = " select * from produto where nome_produto like :palavra%", nativeQuery = true)
	List<Produto> findProdutosPorPalavra(@Param("palavra") String palavra);



}
