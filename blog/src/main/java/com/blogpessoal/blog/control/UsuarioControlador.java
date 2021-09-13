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
import com.blogpessoal.blog.modelos.UsuarioLogin;
import com.blogpessoal.blog.repositorio.UsuarioRepositorio;
import com.blogpessoal.blog.servico.UsuarioServico;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioControlador {

	private @Autowired UsuarioRepositorio repositorio;
	private @Autowired UsuarioServico servicos;

	@GetMapping("/todos")
	public ResponseEntity<List<Usuario>> pegarTodos() {
		List<Usuario> objetoLista = repositorio.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}

		else {
			return ResponseEntity.status(200).body(objetoLista);
		}

	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> objetoSalvar = servicos.cadastrarUsuario(novoUsuario);

		if (objetoSalvar.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			return ResponseEntity.status(201).body(objetoSalvar.get());
		}
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<Usuario> objetoUsuario = repositorio.findById(idUsuario);

		if (objetoUsuario.isPresent()) {
			return ResponseEntity.status(200).body(objetoUsuario.get());
		}

		else {
			return ResponseEntity.status(204).build();
		}
	}

	@PutMapping("/credenciais")
	public ResponseEntity<Object> credenciais(@Valid @RequestBody UsuarioLogin usuarioAutenticar) {
		Optional<?> objetoCredenciais = servicos.autenticador(usuarioAutenticar);

		if (objetoCredenciais.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			return ResponseEntity.status(201).body(objetoCredenciais.get());
		}
	}

	@GetMapping("/nome/{nome_usuario}")
	public ResponseEntity<List<Usuario>> buscarPorNomeI(@PathVariable(value = "nome_usuario") String nome) {
		List<Usuario> objetoLista = repositorio.findAllByNomeContainingIgnoreCase(nome);

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}

		else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<Usuario>> buscarPorNomeII(@RequestParam(defaultValue = "") String nome) {
		List<Usuario> objetoLista = repositorio.findAllByNomeContainingIgnoreCase(nome);

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}

		else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuarioParaAtualizar) {
		return ResponseEntity.status(201).body(repositorio.save(usuarioParaAtualizar));
	}

	@DeleteMapping("/deletar/{id_usuario}")
	public void deletarUsuarioPorId(@PathVariable(value = "id_usuario") Long idUsuario)

	{
		repositorio.deleteById(idUsuario);
	}
}
