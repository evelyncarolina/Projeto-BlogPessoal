package com.blogpessoal.blog.servico;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogpessoal.blog.modelos.Usuario;
import com.blogpessoal.blog.modelos.UsuarioLogin;
import com.blogpessoal.blog.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {

	private @Autowired UsuarioRepositorio repositorio;
	
	/*
	 * Método criado para novo usuario e criptografia de senha
	 * @author Evelyn 
	 * @since 1.6
	 */
	
	public Optional<Object> cadastrarUsuario(Usuario novoUsuario){
		return repositorio.findByEmail(novoUsuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() ->{
			BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
			String result = enconder.encode(novoUsuario.getSenha());
			novoUsuario.setSenha(result);
			return Optional.ofNullable(repositorio.save(novoUsuario));
		});
	}
	
	/*
	 * Método criado para autenticar usuario com o Token
	 * @author Evelyn 
	 * @since 1.6
	 */
	
	public Optional<?> autenticador (UsuarioLogin usuarioAutenticar){
		return repositorio.findByEmail(usuarioAutenticar.getEmail()).map(usuarioExistente -> {
			BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
			
			if (enconder.matches(usuarioAutenticar.getSenha(), usuarioExistente.getSenha())) {

				String estruturaBasic = usuarioAutenticar.getEmail() + ":" + usuarioAutenticar.getSenha(); 
				byte[] autorizacaoBase64 = Base64.encodeBase64(estruturaBasic.getBytes(Charset.forName("US-ASCII"))); 
				String autorizacaoHeader = "Basic " + new String(autorizacaoBase64); 
				
				usuarioAutenticar.setToken(autorizacaoHeader);
				usuarioAutenticar.setId(usuarioExistente.getIdUsuario());
				usuarioAutenticar.setNome(usuarioExistente.getNome());
				usuarioAutenticar.setSenha(usuarioExistente.getSenha());
				return Optional.ofNullable(usuarioAutenticar); 
				
			}
			else {
				return Optional.empty(); //Senha errada 
			}
		}).orElseGet(() -> {
			return Optional.empty(); //Email não existente
		});
		
	}
	
}
