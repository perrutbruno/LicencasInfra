package br.com.alterdata.setorms.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "setores")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_setor")
    private Integer idSetor;

    @Column(name = "codigo_setor")
    private Integer codigoSetor;

    @Column(name = "nome_setor")
    private String nomeSetor;

    @Column(name = "ativo")
    private Boolean ativo;

    //#region Get / Set
    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer id) {
        this.idSetor = id;
    }

    public Integer getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(Integer codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


    //#endregion


}
