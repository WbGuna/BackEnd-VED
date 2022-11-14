package br.com.rd.ved.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.CupomDesconto;

@Repository
public interface CupomDescontoRepository extends JpaRepository<CupomDesconto, Integer>, CrudRepository<CupomDesconto,Integer>{

	@Query(value = "select * from cupom_desconto cd where cd.descricao_desconto = :cupom", nativeQuery = true)
	Optional<CupomDesconto> cupomPorNome(@Param("cupom") String cupom);
}
