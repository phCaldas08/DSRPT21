package br.com.fiap.dsrpt21.repository;

import br.com.fiap.dsrpt21.model.AcaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoRepository extends JpaRepository<AcaoModel, Integer> {
}
