package br.com.lheme.produtoApi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Pedido pedido;
	@OneToOne
	private Produto produto;
	private Integer quantidade;
	private Double valor;
	private Double subTotal;

	public ItemPedido() {
		
	}
	
	public ItemPedido(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = produto.getPreco();
		this.subTotal = (produto.getPreco() * quantidade);
	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = produto.getPreco();
		this.subTotal = (produto.getPreco() * quantidade);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.pedido == null) ? 0 : this.pedido.hashCode());
		result = prime * result + ((this.produto == null) ? 0 : this.produto.hashCode());
		result = prime * result + ((this.quantidade == null) ? 0 : this.quantidade.hashCode());
		result = prime * result + ((this.subTotal == null) ? 0 : this.subTotal.hashCode());
		result = prime * result + ((this.valor == null) ? 0 : this.valor.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		if (this.pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!this.pedido.equals(other.pedido))
			return false;
		if (this.produto == null) {
			if (other.produto != null)
				return false;
		} else if (!this.produto.equals(other.produto))
			return false;
		if (this.quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!this.quantidade.equals(other.quantidade))
			return false;
		if (this.subTotal == null) {
			if (other.subTotal != null)
				return false;
		} else if (!this.subTotal.equals(other.subTotal))
			return false;
		if (this.valor == null) {
			if (other.valor != null)
				return false;
		} else if (!this.valor.equals(other.valor))
			return false;
		return true;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return this.valor;
	}

	public Double getSubTotal() {
		return this.subTotal;
	}

}
