package br.com.fiap.dsrpt21.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "ACAO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcaoModel {

    @Id
    @Column(name = "ID_ACAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACAO_SEQ")
    @SequenceGenerator(name = "ACAO_SEQ", sequenceName = "ACAO_SEQ", allocationSize = 1)
    private Integer idAcao;

    @Column(name = "NOME")
    @NotNull(message = "Nome obrigatório")
    @Size(max = 40, message = "NOME deve ter no maximo 40 caracteres")
    private String nome;

    @Column(name = "DESCRICAO")
    @NotNull(message = "Descricao obrigatória")
    @Size(max = 100, message = "DESCRICAO deve ter no maximo 100 caracteres")
    private String descricao;


    @Column(name = "ATIVO")
    private Boolean ativo;

    @OneToMany(mappedBy = "acao")
    private List<ExecucaoModel> execucoes;

    public AcaoModel() {
    }

    public AcaoModel(Integer idAcao, String nome, String descricao, Boolean ativo) {
        this.idAcao = idAcao;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Integer getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(Integer idAcao) {
        this.idAcao = idAcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<ExecucaoModel> getExecucoes() {
        return execucoes;
    }

    public void setExecucoes(List<ExecucaoModel> execucoes) {
        this.execucoes = execucoes;
    }
}
