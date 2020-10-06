package br.com.alterdata.notafiscalms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;

    //#region Get / Set
    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    //#endregion

}
