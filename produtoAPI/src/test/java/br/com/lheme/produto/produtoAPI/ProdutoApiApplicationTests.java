package br.com.lheme.produto.produtoAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.lheme.produtoApi.ProdutoApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProdutoApiApplication.class)
@TestPropertySource(locations = "classpath:test.properties")
public class ProdutoApiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
