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

import com.blogpessoal.blog.modelos.Usuario;
import com.blogpessoal.blog.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioControlador {
	
	private @Autowired UsuarioRepositorio repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Usuario>> pegarTodos()
	{
	List<Usuario> objetoLista = repositorio.findAll();
	
	/*Essa logica é para voltar o "status" certo*/
	
		if(objetoLista.isEmpty())
		{
			//Se a lista estiver vazia volta o status "204"
			return ResponseEntity.status(204).build();
		}
		
		else
		{
			//Se a lista tiver dados do usuario o status volta "objetoLista", o proprio dados do usuarios
			return ResponseEntity.status(200).body(objetoLista);
		}
	
	}
	
		//Metodo para salvar o usuario no banco de dados
		
		@PostMapping("/salvar")
		public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario novoUsuario)
		{
			return ResponseEntity.status(201).body(repositorio.save(novoUsuario));
		}
		
		@GetMapping("/{id_usuario}")
		public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id_usuario") Long idUsuario)
		{
			Optional<Usuario> objetoUsuario = repositorio.findById(idUsuario);
			
			if(objetoUsuario.isPresent())
			{
				return ResponseEntity.status(200).body(objetoUsuario.get());
			}

			else
			{
				return ResponseEntity.status(204).build();
			}
		}
		
		@GetMapping("/nome/{nome_usuario}")
		public ResponseEntity<List<Usuario>> buscarPorNomeI(@PathVariable(value = "nome_usuario") String nome)
		{
			List<Usuario> objetoLista = repositorio.findAllByNomeContainingIgnoreCase(nome);
			
			if (objetoLista.isEmpty()) 
			{
				return ResponseEntity.status(204).build();
			} 
			
			else 
			{
				return ResponseEntity.status(200).body(objetoLista);
			}
		}
		
		@GetMapping("/pesquisa")
		public ResponseEntity<List<Usuario>> buscarPorNomeII(@RequestParam(defaultValue = "") String nome)
		{
			List<Usuario> objetoLista = repositorio.findAllByNomeContainingIgnoreCase(nome);
			
			if (objetoLista.isEmpty()) {
				return ResponseEntity.status(204).build();
			} 
			
			else 
			{
				return ResponseEntity.status(200).body(objetoLista);
			}
		}
		
		@PutMapping("/atualizar")
		public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuarioParaAtualizar)
		{
			return ResponseEntity.status(201).body(repositorio.save(usuarioParaAtualizar));
		}
		
		@DeleteMapping("/deletar/{id_usuario}")
		public void deletarUsuarioPorId(@PathVariable(value = "id_usuario") Long idUsuario) 
		
		{
			repositorio.deleteById(idUsuario);
		}
}















