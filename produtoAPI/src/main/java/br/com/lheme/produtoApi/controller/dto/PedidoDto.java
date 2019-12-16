package br.com.lheme.produtoApi.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.lheme.produtoApi.modelo.Pedido;

public class PedidoDto {
	
	private Long id;
	private LocalDateTime data;
	private String cliente;
	private Integer quantidadeItens;
	private Double total;

	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.data = pedido.getData();
		this.cliente = pedido.getCliente().getNome();
		this.quantidadeItens = pedido.getQuantidadeItens();
		this.total = pedido.getTotalPedido();
	}

	public Long getId() {
		return this.id;
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

	public static Page<PedidoDto> converter(Page<Pedido> pedidos) {
		return pedidos.map(PedidoDto::new);
	}
	
}
