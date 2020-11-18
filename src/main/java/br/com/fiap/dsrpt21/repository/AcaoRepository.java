package br.com.fiap.dsrpt21.repository;

import br.com.fiap.dsrpt21.model.AcaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AcaoRepository extends JpaRepository<AcaoModel, Integer> {

}
