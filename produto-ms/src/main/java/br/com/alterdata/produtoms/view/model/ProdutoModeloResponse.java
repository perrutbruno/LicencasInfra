package br.com.alterdata.produtoms.view.model;

public class ProdutoModeloResponse {
    private Integer idProduto;
    private Integer codigoProduto;
    private String nomeProduto;
    private String modeloProduto;
    private String versaoProduto;
    private String descricaoProduto;
    private String observacaoProduto;
    private Integer ativo;


    //#region Get / Set
    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getModeloProduto() {
        return modeloProduto;
    }

    public void setModeloProduto(String modeloProduto) {
        this.modeloProduto = modeloProduto;
    }

    public String getVersaoProduto() {
        return versaoProduto;
    }

    public void setVersaoProduto(String versaoProduto) {
        this.versaoProduto = versaoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getObservacaoProduto() {
        return observacaoProduto;
    }

    public void setObservacaoProduto(String observacaoProduto) {
        this.observacaoProduto = observacaoProduto;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }
    //#endregion
    
}
