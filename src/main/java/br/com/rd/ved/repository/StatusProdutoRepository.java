package br.com.rd.ved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.StatusProduto;

@Repository
public interface StatusProdutoRepository extends JpaRepository<StatusProduto, Integer>, CrudRepository<StatusProduto,Integer>{

}
