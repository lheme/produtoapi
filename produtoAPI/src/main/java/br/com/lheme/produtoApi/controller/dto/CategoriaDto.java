package br.com.lheme.produtoApi.controller.dto;

import org.springframework.data.domain.Page;

import br.com.lheme.produtoApi.modelo.Categoria;

public class CategoriaDto {
	
	private Long id;
	private String descricao;

	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.descricao = categoria.getNome();
	}

	public Long getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static Page<CategoriaDto> converter(Page<Categoria> categorias) {
		return categorias.map(CategoriaDto::new);
	}

}
