package br.com.alterdata.licenciamentoms.view.model;

import br.com.alterdata.licenciamentoms.dto.Produto;
import br.com.alterdata.licenciamentoms.dto.Setor;

public class LicenciamentoModeloResponse {
    private Integer id;
    private String maquina;
    private String tipoMaquina;
    private String usuario;
    private String observacao;
    private Produto produto;
    private Setor setor;

    //#region Get/Set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    //#endregion
}
