package br.com.lheme.produtoApi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne 
	private Categoria categoria;
	private Double preco;
	private Integer quantidade;
	private String descricao;
	private String foto;
	private Boolean removido = Boolean.FALSE;
	
	
	public Produto() {
		
	}
	
	public Produto(String descricao, Integer quantidade, Double valor, Categoria categoria) {
		this.categoria = categoria;
		this.preco = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.categoria == null) ? 0 : this.categoria.hashCode());
		result = prime * result
				+ ((this.descricao == null) ? 0 : this.descricao.hashCode());
		result = prime * result
				+ ((this.foto == null) ? 0 : this.foto.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result
				+ ((this.preco == null) ? 0 : this.preco.hashCode());
		result = prime * result
				+ ((this.quantidade == null) ? 0 : this.quantidade.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (this.categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!this.categoria.equals(other.categoria))
			return false;
		if (this.descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!this.descricao.equals(other.descricao))
			return false;
		if (this.foto == null) {
			if (other.foto != null)
				return false;
		} else if (!this.foto.equals(other.foto))
			return false;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		if (this.preco == null) {
			if (other.preco != null)
				return false;
		} else if (!this.preco.equals(other.preco))
			return false;
		if (this.quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!this.quantidade.equals(other.quantidade))
			return false;
		return true;
	}
	
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Categoria getCategoria() {
		return this.categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Double getPreco() {
		return this.preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFoto() {
		return this.foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getNomeCategoria() {
		return this.categoria.getNome();
	}

	public Boolean getRemovido() {
		return this.removido;
	}

	public void setRemovido(Boolean removido) {
		this.removido = removido;
	}
}

