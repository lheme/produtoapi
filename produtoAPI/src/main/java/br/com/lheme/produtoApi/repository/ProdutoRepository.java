package br.com.lheme.produtoApi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.lheme.produtoApi.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("SELECT p FROM Produto p WHERE (p.removido = false OR p.removido IS NULL)")
	Page<Produto> listarProdutos(Pageable pageable);

	Produto findByDescricao(String nomeProduto);
	
}
