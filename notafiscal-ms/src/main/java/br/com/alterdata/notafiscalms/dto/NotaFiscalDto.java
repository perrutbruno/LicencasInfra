package br.com.alterdata.notafiscalms.dto;

import java.util.Date;
import java.util.List;

import br.com.alterdata.notafiscalms.model.ItensNotaFiscal;

public class NotaFiscalDto {
    private Integer idNotaFiscal;
    private String codigoNotaFiscal; //caso seja um INVOICE pode conter caracteres não numéricos
    private Date dataEmissao;
    private String nomeArquivo;
    private String caminhoArquivo;
    private String descricao;
    private String observacao;
    private String atendimento;
    private Fornecedor fornecedor;
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
