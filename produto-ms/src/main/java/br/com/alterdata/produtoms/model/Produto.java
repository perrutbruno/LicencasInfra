package br.com.alterdata.produtoms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "codigo_produto")
    private Integer codigoProduto;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "modelo")
    private String modeloProduto;

    @Column(name = "versao")
    private String versaoProduto;

    @Column(name = "descricao")
    private String descricaoProduto;
    
    @Column(name = "observacao")
    private String observacaoProduto;

    @Column(name = "ativo")
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
