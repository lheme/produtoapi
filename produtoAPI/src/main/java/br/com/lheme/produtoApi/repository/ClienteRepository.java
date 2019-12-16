package br.com.lheme.produtoApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.lheme.produtoApi.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByNome(String nomeCliente);

	Optional<Cliente> findByEmail(String email);

}
