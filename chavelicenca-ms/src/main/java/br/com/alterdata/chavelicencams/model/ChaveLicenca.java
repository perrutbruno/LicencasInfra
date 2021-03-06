package br.com.alterdata.chavelicencams.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.alterdata.chavelicencams.dto.Produto;

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

    @Column(name = "qtd_ativacao_permitida")
    private Integer qtdAtivacaoPermitida;

    @Column(name = "qtd_ativacao_realizada")
    private Integer qtdAtivacaoRealizada;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;

    @Column(name = "ativo")
    private Integer ativo;

    // #endregion
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    // #endregion

}
