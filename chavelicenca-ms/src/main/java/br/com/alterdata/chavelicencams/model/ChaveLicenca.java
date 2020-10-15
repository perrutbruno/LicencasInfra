package br.com.alterdata.chavelicencams.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chaves_licencas")
public class ChaveLicenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chave_licenca")
    private Integer idChaveLicenca;

    @Column(name = "chave")
    private String chave;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "quantidade_uso")
    private Integer qtdUso;

    @Column(name = "id_produto")
    private Integer idProduto;

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

    //#endregion
    
}
