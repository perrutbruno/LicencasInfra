package br.com.alterdata.fornecedorms.dto;

public class FornecedorDto {
    private Integer idFornecedor;
    private Integer codigoFornecedor;
    private String nomeFornecedor;
    private String cnpjFornecedor;
    private Boolean ativo;

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
      

    
}
