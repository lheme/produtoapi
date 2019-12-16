package br.com.lheme.produtoApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lheme.produtoApi.modelo.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

}
