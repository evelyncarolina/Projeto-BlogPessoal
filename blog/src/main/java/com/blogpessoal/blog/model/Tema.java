package com.blogpessoal.blog.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 

public class Tema {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTema;
	private @NotBlank String tema;
	
	@OneToMany(mappedBy = "temaRelacionador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"temaRelacionador"})
	private List<Postagem> meuTema = new ArrayList<>();
	
	
	public Long getIdTema() {
		return idTema;
	}
	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public List<Postagem> getMeuTema() {
		return meuTema;
	}
	public void setMeuTema(List<Postagem> meuTema) {
		this.meuTema = meuTema;
	}
	
}
