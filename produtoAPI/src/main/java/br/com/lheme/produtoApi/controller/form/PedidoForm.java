package br.com.lheme.produtoApi.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.lheme.produtoApi.modelo.Cliente;
import br.com.lheme.produtoApi.modelo.ItemPedido;
import br.com.lheme.produtoApi.modelo.Pedido;
import br.com.lheme.produtoApi.repository.ClienteRepository;
import br.com.lheme.produtoApi.repository.ProdutoRepository;

public class PedidoForm {
	
	@NotNull @NotEmpty
	private List<ItemPedidoForm> itensPedido;
	@NotNull @NotEmpty @Length(min = 3)
	private String nomeCliente;
	
	public PedidoForm() {
		this.itensPedido = new ArrayList<ItemPedidoForm>();
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public List<ItemPedidoForm> getItensPedido() {
		return itensPedido;
	}

	public Pedido paraPedido(ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.findByNome(nomeCliente);
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		
		itensPedido.forEach(item -> {
			itens.add(item.paraItemPedido(produtoRepository));
		});
		return new Pedido(cliente, itens);
	}

	public List<ItemPedido> paraItenPedido(Pedido pedido, ProdutoRepository produtoRepository) {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		
		itensPedido.forEach(item -> {
			itens.add(item.paraItemPedido(pedido, produtoRepository));
		});
		return itens;
	}
}
