package br.com.fiap.dsrpt21.repository;

import br.com.fiap.dsrpt21.model.ExecucaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecucaoRepository extends JpaRepository<ExecucaoModel, Integer> {
}
