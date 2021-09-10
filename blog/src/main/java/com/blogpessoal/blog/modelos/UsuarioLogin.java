package com.blogpessoal.blog.modelos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioLogin {

	private @NotBlank @Email String email; 
	private @NotBlank String senha;
	
	private Long id;
	private String nome;
	private String token;
	
	
	public UsuarioLogin(String email, String senha, Long id, String nome) {
		this.email = email;
		this.senha = senha;
		this.id = id;
		this.nome = nome;
	}
	public UsuarioLogin() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
