package br.com.alterdata.notafiscalms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itens_nf")
public class ItensNotaFiscal {
    @Column(name="id_nota_fiscal")
    private Integer id_nota_fiscal;

    @Column(name="id_produto")
    private Integer id_produto;

    @Column(name = "quantidade")
    private Integer quantidade;


    //#region Get / Set
   
    public Integer getId_nota_fiscal() {
        return id_nota_fiscal;
    }

    public void setId_nota_fiscal(Integer id_nota_fiscal) {
        this.id_nota_fiscal = id_nota_fiscal;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    //#endregion

    
}
