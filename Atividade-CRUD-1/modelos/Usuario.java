package com.blogpessoal.blog.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity //isso aqui é 

public class Usuario {
	
	/**
	 * Classe utilizada como Entidade no Banco de dados para Postagem, a mesma
	 * possui atributos que seram colunas no banco com titulo : titulo, descricao
	 * 
	 * @author Evelyn
	 * @since 1.0
	 */
	
	/*"Id" vai ser a chave primaria 
	 * "Generate" serve para colocar um incremento ou seja para fazer contagem a partir do 1
	 */
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)Long idUsuario;
	private String nome;
	private @NotBlank @Email String email;
	private @NotBlank String senha;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

	
}
