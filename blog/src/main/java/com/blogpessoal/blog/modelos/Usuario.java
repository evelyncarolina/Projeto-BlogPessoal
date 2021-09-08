package com.blogpessoal.blog.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity //isso aqui é 

public class Usuario {
	
	/**
	 * Classe utilizada como Entidade no Banco de dados para Postagem, a mesma
	 * possui atributos que seram colunas no banco com titulo : titulo, descricao
	 * 
	 * @author Evelyn
	 * @since 1.0
	 */

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)Long idUsuario;
	private String nome;
	private @NotBlank @Size(min = 6) String usuario;
	private @NotBlank @Email String email;
	private @NotBlank @Size(min = 6) String senha;
	
	@OneToMany(mappedBy = "usuarioRelacionador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"usuarioRelacionador"})
	private List<Postagem> minhasPostagens = new ArrayList<>();
	
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	public List<Postagem> getMinhasPostagens() {
		return minhasPostagens;
	}
	public void setMinhasPostagens(List<Postagem> minhasPostagens) {
		this.minhasPostagens = minhasPostagens;
	}
	
}
