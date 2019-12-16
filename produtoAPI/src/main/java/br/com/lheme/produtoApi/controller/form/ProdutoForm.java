package br.com.lheme.produtoApi.controller.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.lheme.produtoApi.modelo.Categoria;
import br.com.lheme.produtoApi.modelo.Produto;
import br.com.lheme.produtoApi.repository.CategoriaRepository;

public class ProdutoForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull @NotEmpty @Length(min = 5)
	private String nomeCategoria;
	@NotNull
	private Integer quantidade;
	@NotNull @DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 4, fraction = 2)
	private Double valor;
	
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNomeCategoria() {
		return this.nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
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
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Produto paraProduto(CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
		return new Produto(descricao, quantidade, valor, categoria);
	}
}
