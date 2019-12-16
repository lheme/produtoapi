package br.com.lheme.produtoApi.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.lheme.produtoApi.modelo.Pedido;

public class DetalhesDoPedidoDto {

	private Long idPedido;
	private LocalDateTime data;
	private String cliente;
	private Integer quantidadeItens;
	private Double total;
	private List<ItemPedidoDto> itensPedido;

	public DetalhesDoPedidoDto (Pedido pedido) {
		this.idPedido = pedido.getId();
		this.data = pedido.getData();
		this.cliente = pedido.getCliente().getNome();
		this.quantidadeItens = pedido.getItensPedido().size();
		this.total = pedido.getTotalPedido();
		this.itensPedido = new ArrayList<ItemPedidoDto>();
		System.out.println(pedido.getItensPedido());
		this.itensPedido.addAll(pedido.getItensPedido().stream().map(ItemPedidoDto::new).collect(Collectors.toList()));
	}


	public Long getIdPedido() {
		return idPedido;
	}

	public LocalDateTime getData() {
		return this.data;
	}

	public String getCliente() {
		return this.cliente;
	}

	public Integer getQuantidadeItens() {
		return this.quantidadeItens;
	}

	public Double getTotal() {
		return this.total;
	}

	public List<ItemPedidoDto> getItensPedido() {
		return this.itensPedido;
	}

	
}
