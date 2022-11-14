package br.com.rd.ved.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Integer>,  CrudRepository<Frete,Integer>{

	@Query(value = "select * from frete f "
			+ "inner join tipo_frete tf on f.id_tipo_frete = tf.id_tipo_frete "
			+ "inner join uf on f.id_uf = uf.id_uf "
			+ "where uf.id_uf = :tipo ", nativeQuery = true)
	List<Frete> findFretePorTipo(@Param("tipo")Integer tipo);
	
	
}

