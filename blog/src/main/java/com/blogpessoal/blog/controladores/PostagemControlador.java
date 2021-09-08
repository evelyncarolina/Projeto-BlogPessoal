package com.blogpessoal.blog.controladores;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.blog.modelos.Postagem;
import com.blogpessoal.blog.repositorio.PostagemRepositorio;

@RestController
@RequestMapping("/api/v1/postagem")
public class PostagemControlador {

	private @Autowired PostagemRepositorio repositorio;

	@GetMapping("/todas")
	public ResponseEntity<List<Postagem>> pegarTodos() {
		List<Postagem> objetoPostagem = repositorio.findAll();

		if (objetoPostagem.isEmpty()) {
			return ResponseEntity.status(204).build();
		} 
		else {
			return ResponseEntity.status(201).body(objetoPostagem);
		}
	}

	@GetMapping("/idPostagem/{idPostagem}")
	public ResponseEntity<Postagem> buscaId(@PathVariable (value = "idPostagem") Long idPostagem){
		Optional<Postagem> objetoId = repositorio.findById(idPostagem);
		
		if(objetoId.isPresent()) {
			return ResponseEntity.status(201).body(objetoId.get());
		}
		else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Postagem> paraSalvar(@Valid @RequestBody Postagem salvarId){
		return ResponseEntity.status(201).body(repositorio.save(salvarId));
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> buscarPorTituloI(@PathVariable(value = "titulo") String Titulo) {
		List<Postagem> objetoTitulo = repositorio.findAllByTituloContainingIgnoreCase(Titulo);
		
		if(objetoTitulo.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(objetoTitulo);
		}
	}
	
	public ResponseEntity<List<Postagem>> buscaPorTituloII(@RequestParam(defaultValue = "") String Titulo) {
		List<Postagem> objetoTitulo = repositorio.findAllByTituloContainingIgnoreCase(Titulo);
		
		if(objetoTitulo.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(objetoTitulo);
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Postagem> atualizar(@Valid @RequestBody Postagem postagemAtualizar) {
		return ResponseEntity.status(201).body(repositorio.save(postagemAtualizar));
	}
	
	@DeleteMapping("/deletar/{deletar}")
	public void deletarPostagemId (@PathVariable (value = "deletar") Long idPostagem) {
		repositorio.deleteById(idPostagem);
	}

}
