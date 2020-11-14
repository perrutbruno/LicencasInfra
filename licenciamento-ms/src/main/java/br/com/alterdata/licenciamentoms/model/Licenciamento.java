package br.com.alterdata.licenciamentoms.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.alterdata.licenciamentoms.dto.Produto;
import br.com.alterdata.licenciamentoms.dto.Setor;

@Entity
@Table(name = "licenciamentos")
public class Licenciamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_licenciamento")
    private Integer id;

    @Column(name="maquina")
    private String maquina;

    @Column(name="tipo_maquina")
    private String tipoMaquina;

    @Column(name="usuario")
	private String usuario;

	@Column(name="observacao")
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")
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
