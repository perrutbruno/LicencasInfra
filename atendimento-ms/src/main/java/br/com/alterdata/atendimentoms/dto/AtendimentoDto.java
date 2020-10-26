package br.com.alterdata.atendimentoms.dto;

public class AtendimentoDto {
    private Integer idAtendimento;
    private String numeroAtendimento;
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
