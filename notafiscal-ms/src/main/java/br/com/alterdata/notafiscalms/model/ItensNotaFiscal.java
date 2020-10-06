package br.com.alterdata.notafiscalms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itens_nf")
public class ItensNotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item_nf")
    private Integer idItemNnf;

    @Column(name="id_nota_fiscal")
    private Integer idNotaFiscal;

    @Column(name="id_produto")
    private Integer idProduto;

    @Column(name = "quantidade")
    private Integer quantidade;

    

    //#region Get / Set
   
    public Integer getIdItemNnf() {
        return idItemNnf;
    }

    public void setIdItemNnf(Integer idItemNnf) {
        this.idItemNnf = idItemNnf;
    }

    public Integer getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(Integer idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    //#endregion

    
}
