package br.com.sunsystem.entregas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sunsystem.entregas.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
