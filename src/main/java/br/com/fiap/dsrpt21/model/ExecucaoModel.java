package br.com.fiap.dsrpt21.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EXECUCAO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExecucaoModel {

    @Id
    @Column(name = "ID_EXECUCAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXEC_SEQ")
    @SequenceGenerator(name = "EXEC_SEQ", sequenceName = "EXEC_SEQ", allocationSize = 1)
    private Integer idExecucao;

    @Column(name = "DATA_EXECUCAO")
    private Date dataExecucao;

    @ManyToOne()
    @JoinColumn(name = "ID_ACAO", nullable = false)
    private AcaoModel acao;

    public ExecucaoModel() {
    }

    public ExecucaoModel(Integer idExecucao, Date dataExecucao) {
        this.idExecucao = idExecucao;
        this.dataExecucao = dataExecucao;
    }

    public Integer getIdExecucao() {
        return idExecucao;
    }

    public void setIdExecucao(Integer idExecucao) {
        this.idExecucao = idExecucao;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public AcaoModel getAcao() {
        return acao;
    }

    public void setAcao(AcaoModel acao) {
        this.acao = acao;
    }
}
