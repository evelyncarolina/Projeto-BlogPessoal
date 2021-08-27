package com.blogpessoal.blog.controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.blog.modelos.Tema;
import com.blogpessoal.blog.repositorio.TemaRepositorio;


@RestController
@RequestMapping("/api/v1/tema")
public class TemaControlador {

	private @Autowired TemaRepositorio repositorio;
	
	@GetMapping("/todos")
	public List<Tema> pegarTodos()
	{
		return repositorio.findAll();
	}

}
