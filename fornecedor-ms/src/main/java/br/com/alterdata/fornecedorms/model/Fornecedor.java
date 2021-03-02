package br.com.alterdata.fornecedorms.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;

    @Column(name = "codigo_fornecedor")
    private Integer codigoFornecedor;

    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;

    @Column(name = "cnpj_fornecedor")
    private String cnpjFornecedor;

    @Column(name = "ativo")
    private Boolean ativo;

    


    //#region Get / Set
	public Integer getIdFornecedor() {
		return idFornecedor;
    }
    
	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
    }
    
    public Integer getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(Integer codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
    }
    
	public String getNomeFornecedor() {
		return nomeFornecedor;
    }
    
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
    }
    
	public String getCnpjFornecedor() {
		return cnpjFornecedor;
    }
    
	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
    }

    public Boolean getAtivo() {
      return ativo;
    }

    public void setAtivo(Boolean ativo) {
      this.ativo = ativo;
    }
    

    //#endregion


    
}
