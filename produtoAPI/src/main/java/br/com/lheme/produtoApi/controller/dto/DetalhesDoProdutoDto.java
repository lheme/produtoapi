package br.com.lheme.produtoApi.controller.dto;

import br.com.lheme.produtoApi.modelo.Produto;

/**
 * @author LHEME DEV - Luiz Leme
 *
 */
public class DetalhesDoProdutoDto {

	private Long id;
	private String categoria;
	private String descricao;
	private Integer quantidade;
	private Double preco;
	private String descontinuado;
	
	public DetalhesDoProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.categoria = produto.getNomeCategoria();
		this.descricao = produto.getDescricao();
		this.quantidade = produto.getQuantidade();
		this.preco = produto.getPreco();
		this.descontinuado = produto.getRemovido() ? "Sim" : "Não";
	}

	public Long getId() {
		return this.id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public Double getPreco() {
		return this.preco;
	}

	public String getDescontinuado() {
		return this.descontinuado;
	}
	
	
}
