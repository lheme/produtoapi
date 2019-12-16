package br.com.lheme.produtoApi.controller.dto;

import br.com.lheme.produtoApi.modelo.ItemPedido;

public class ItemPedidoDto {

	private Long idItemPedido;
	private String descricaoProduto;
	private Integer quantidade;
	private Double valor;
	private Double subTotal;
	
	public ItemPedidoDto(ItemPedido itemPedido) {
		this.idItemPedido = itemPedido.getId();
		this.descricaoProduto = itemPedido.getProduto().getDescricao();
		this.quantidade = itemPedido.getQuantidade();
		this.valor = itemPedido.getValor();
		this.subTotal = itemPedido.getSubTotal();
	}

	
	public Long getIdItemPedido() {
		return idItemPedido;
	}

	public String getDescricaoProduto() {
		return this.descricaoProduto;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public Double getValor() {
		return this.valor;
	}

	public Double getSubTotal() {
		return this.subTotal;
	}
}
