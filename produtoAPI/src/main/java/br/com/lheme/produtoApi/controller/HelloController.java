package br.com.lheme.produtoApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return " BEM-VINDO A LHEME(LUIZ H LEME) PRODUTOS REST API EM SPRING BOOT!!!"; 
	}

}
