package br.com.alterdata.atendimentoms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atendimentos")
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Integer idAtendimento;

    @Column(name = "numero_atendimento")
    private String numeroAtendimento;

    @Column(name = "descricao")
    private String descricao;

    //#region get / set
    public Integer getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(Integer idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public String getNumeroAtendimento() {
        return numeroAtendimento;
    }

    public void setNumeroAtendimento(String numeroAtendimento) {
        this.numeroAtendimento = numeroAtendimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    //#endregion
}
