package br.com.alterdata.ativacaoms.dto;

import java.util.Date;

public class AtivacaoDto {
    private Integer id;
    private String atendimento;
    private Date dataAtivacao;
    private Integer idLicenciamento;

    //#region Get/Set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    public Date getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(Date dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public Integer getIdLicenciamento() {
        return idLicenciamento;
    }

    public void setIdLicenciamento(Integer idLicenciamento) {
        this.idLicenciamento = idLicenciamento;
    }

    //#endregion
}
