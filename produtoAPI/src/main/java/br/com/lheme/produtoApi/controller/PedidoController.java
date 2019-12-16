package br.com.lheme.produtoApi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lheme.produtoApi.controller.dto.DetalhesDoPedidoDto;
import br.com.lheme.produtoApi.controller.dto.PedidoDto;
import br.com.lheme.produtoApi.controller.form.PedidoForm;
import br.com.lheme.produtoApi.modelo.ItemPedido;
import br.com.lheme.produtoApi.modelo.Pedido;
import br.com.lheme.produtoApi.repository.ClienteRepository;
import br.com.lheme.produtoApi.repository.ItemPedidoRepository;
import br.com.lheme.produtoApi.repository.PedidoRepository;
import br.com.lheme.produtoApi.repository.ProdutoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRespository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired 
	private ClienteRepository clienteRepository;

	@GetMapping
	public Page<PedidoDto> listar(
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		Page<Pedido> pedidos = pedidoRepository.findAll(paginacao);
		return PedidoDto.converter(pedidos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoPedidoDto> detalhar(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoPedidoDto(pedido.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PedidoDto> cadastrar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {
		Pedido pedido = form.paraPedido(produtoRepository, clienteRepository);
		pedidoRepository.save(pedido);
		
		List<ItemPedido> itensPedido = form.paraItenPedido(pedido, produtoRepository);
		itemPedidoRespository.saveAll(itensPedido);
		
		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDto(pedido));	
	}
}
