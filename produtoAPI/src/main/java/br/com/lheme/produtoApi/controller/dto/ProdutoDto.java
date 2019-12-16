package br.com.lheme.produtoApi.controller.dto;

import org.springframework.data.domain.Page;

import br.com.lheme.produtoApi.modelo.Produto;

public class ProdutoDto {
	
	private Long id;
	private String descricao;
	
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
	}
	

	public Long getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static Page<ProdutoDto> converter(Page<Produto> produtos) {
		return produtos.map(ProdutoDto::new);
	}
}
