package br.com.alterdata.notafiscalms.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "itens_nf")
public class ItensNotaFiscal {
    @EmbeddedId
    private ItensNfId id;

    @Column(name = "quantidade")
    private Integer quantidade;


    //#region Get / Set
    public ItensNfId getId() {
        return id;
    }

    public void setId(ItensNfId id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    //#endregion

    
}
