package br.com.lheme.produtoApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lheme.produtoApi.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNome(String categoria);

}
