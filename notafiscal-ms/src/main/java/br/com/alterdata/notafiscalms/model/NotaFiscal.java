package br.com.alterdata.notafiscalms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.alterdata.notafiscalms.dto.Fornecedor;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_nota_fiscal")
    private Integer idNotaFiscal;

    @Column(name="codigo_nota_fiscal")
    private String codigoNotaFiscal; //caso seja um INVOICE pode conter caracteres não numéricos
    
    @Column(name="data_emissao")
    private Date dataEmissao;

    @Column(name="nome_arquivo")
    private String nomeArquivo;

    @Column(name="caminho_arquivo")
    private String caminhoArquivo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="observacao")
    private String observacao;
    
    @Column(name="atendimento")
    private String atendimento;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
    private Fornecedor fornecedor;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "itens_nf"
        , joinColumns = @JoinColumn(name = "id_nota_fiscal", referencedColumnName = "id_nota_fiscal")
        , inverseJoinColumns = @JoinColumn(name = "id_item_nf", referencedColumnName = "id_item_nf")
    )
    private List<ItensNotaFiscal> itens;

    //#region Get / Set
    public Integer getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(Integer idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public String getCodigoNotaFiscal() {
        return codigoNotaFiscal;
    }

    public void setCodigoNotaFiscal(String codigoNotaFiscal) {
        this.codigoNotaFiscal = codigoNotaFiscal;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ItensNotaFiscal> getItens() {
        return itens;
    }

    public void setItens(List<ItensNotaFiscal> itens) {
        this.itens = itens;
    }

    //#endregion


}
