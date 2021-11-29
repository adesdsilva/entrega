package br.com.sunsystem.entregas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sunsystem.entregas.model.EntregaNew;

@Repository
public interface EntregaNewRepository extends JpaRepository<EntregaNew, Long> {

}
