package com.blogpessoal.blog.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.blog.modelos.Postagem;
import com.blogpessoal.blog.repositorio.PostagemRepositorio;


@RestController
@RequestMapping("/api/v1/postagem")
public class PostagemControlador {
	
	private @Autowired PostagemRepositorio repositorio;
	
	@GetMapping("/todas")
	public List<Postagem> pegarTodos()
	{
		return repositorio.findAll();
	}


}
