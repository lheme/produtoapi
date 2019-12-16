package br.com.lheme.produtoApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lheme.produtoApi.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
