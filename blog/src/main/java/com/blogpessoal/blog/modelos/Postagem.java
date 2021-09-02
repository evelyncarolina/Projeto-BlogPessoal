package com.blogpessoal.blog.modelos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity 
@Table(name = "postagem")

public class Postagem {
	
	/**
	 * Classe utilizada como Entidade no Banco de dados para Postagem, a mesma
	 * possui atributos que seram colunas no banco com titulo : titulo, descricao
	 * 
	 * @author Evelyn
	 * @since 1.0
	 */

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idPostagem;
	private @NotBlank String titulo;
	private @NotBlank String descricao;
	
	@Temporal(TemporalType.TIMESTAMP) // Data da postagem
    private Date data = new java.sql.Date(System.currentTimeMillis());
	
	public Long getIdPostagem() {
		return idPostagem;
	}
	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
