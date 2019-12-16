package br.com.lheme.produtoApi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.lheme.produtoApi.modelo.ItemPedido;
import br.com.lheme.produtoApi.modelo.Pedido;
import br.com.lheme.produtoApi.modelo.Produto;
import br.com.lheme.produtoApi.repository.ProdutoRepository;

public class ItemPedidoForm {
	
	@NotNull @NotEmpty @Length (min = 5)
	private String nomeProduto;
	@NotNull @NotEmpty
	private Integer quantidade;
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public ItemPedido paraItemPedido(ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.findByDescricao(this.nomeProduto);
		return new ItemPedido(produto, quantidade);
	}

	public ItemPedido paraItemPedido(Pedido pedido, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.findByDescricao(this.nomeProduto);
		
		if (produto.getQuantidade() >= quantidade) {
			produto.setQuantidade(produto.getQuantidade() - quantidade);
			return new ItemPedido(pedido, produto, quantidade);
		} else {
			return new ItemPedido(pedido, null, quantidade);
		}
		
	}
}
