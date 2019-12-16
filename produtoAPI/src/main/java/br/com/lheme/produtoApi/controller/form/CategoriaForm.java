package br.com.lheme.produtoApi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.lheme.produtoApi.modelo.Categoria;
import br.com.lheme.produtoApi.repository.CategoriaRepository;

public class CategoriaForm {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String nome;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria toCategoria() {
		return new Categoria(this.nome);
	}

	public Categoria atualizar(Long id,
			CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.getOne(id);
		categoria.setNome(this.nome);
		return categoria;
	}
}
