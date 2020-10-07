package br.com.alterdata.notafiscalms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.alterdata.notafiscalms.dto.Produto;

@Entity
@Table(name = "itens_nf")
public class ItensNotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item_nf")
    private Integer idItemNnf;

    @Column(name="id_nota_fiscal")
    private Integer idNotaFiscal;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
     private Produto produtos;

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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

 

    //#endregion

    
}
