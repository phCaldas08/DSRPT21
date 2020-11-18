package br.com.fiap.dsrpt21.repository;

import br.com.fiap.dsrpt21.model.AcaoModel;
import br.com.fiap.dsrpt21.model.ExecucaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExecucaoRepository extends JpaRepository<ExecucaoModel, Integer> {

    @Query("SELECT DISTINCT e.acao FROM ExecucaoModel e")
    List<AcaoModel> findByExecucoesIsNotNull();

}
