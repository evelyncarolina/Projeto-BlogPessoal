package com.blogpessoal.blog.controladores;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.blog.modelos.Tema;
import com.blogpessoal.blog.repositorio.TemaRepositorio;

@RestController
@RequestMapping("/api/v1/tema")
public class TemaControlador {

	private @Autowired TemaRepositorio repositorio;

	@GetMapping("/todos")
	public ResponseEntity<List<Tema>> pegarTodos() {
		List<Tema> objetoTema = repositorio.findAll();

		if (objetoTema.isEmpty()) {

			return ResponseEntity.status(204).build();
		} 
		else {
			return ResponseEntity.status(200).body(objetoTema);
		}
	}

	@GetMapping("/id/{todosId}")
	public ResponseEntity<Tema> buscaId(@PathVariable(value = "todosId") Long idTema) {

		Optional<Tema> objetoId = repositorio.findById(idTema);

		if (objetoId.isPresent()) {
			return ResponseEntity.status(200).body(objetoId.get());
		} 
		else {
			return ResponseEntity.status(204).build();
		}

	}

	@PutMapping("/atualizar")
	public ResponseEntity<Tema> salvarId(@Valid @RequestBody Tema paraSalvar){
		
		return ResponseEntity.status(200).body(repositorio.save(paraSalvar));	
	}

	@DeleteMapping("/deletar{deletarId}")
	public void Delete (@PathVariable (value = "deletarId") Long paraDeletar) {
		repositorio.deleteById(paraDeletar);
	}
	
}


