package br.com.alterdata.notafiscalms.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

@Embeddable
public class ItensNfId implements Serializable{
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_nota_fiscal", referencedColumnName = "id_nota_fiscal")
    private NotaFiscal notaFiscal;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Producer produto;

    //#region Get / Set
    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    //#endregion
    
}
