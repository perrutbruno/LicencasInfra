package br.com.alterdata.chavelicencams.dto;

public class ChaveLicencaDto {
    private Integer idChaveLicenca;
    private String chave;
    private Integer quantidade;
    private Integer qtdUso;
    private Integer idProduto;
    private Integer ativo;
    private Integer qtdAtivacaoPermitida;
    private Integer qtdAtivacaoRealizada;

    //#endregion
    public Integer getIdChaveLicenca() {
        return idChaveLicenca;
    }

    public void setIdChaveLicenca(Integer idChaveLicenca) {
        this.idChaveLicenca = idChaveLicenca;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQtdUso() {
        return qtdUso;
    }

    public void setQtdUso(Integer qtdUso) {
        this.qtdUso = qtdUso;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Integer getQtdAtivacaoPermitida() {
        return qtdAtivacaoPermitida;
    }

    public void setQtdAtivacaoPermitida(Integer qtdAtivacaoPermitida) {
        this.qtdAtivacaoPermitida = qtdAtivacaoPermitida;
    }

    public Integer getQtdAtivacaoRealizada() {
        return qtdAtivacaoRealizada;
    }

    public void setQtdAtivacaoRealizada(Integer qtdAtivacaoRealizada) {
        this.qtdAtivacaoRealizada = qtdAtivacaoRealizada;
    }

    //#endregion 
}
