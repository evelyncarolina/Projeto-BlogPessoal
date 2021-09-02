package com.blogpessoal.blog.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.blog.modelos.Postagem;

@Repository
public interface PostagemRepositorio extends JpaRepository<Postagem, Long> {
	
	/**
	 * Método utilizado para pesquisar coluna titulo ContainigIgnoreCase
	 * 
	 * @param titulo do tipo String
	 * @return List de Postagens
	 * @author Evelyn
	 */
	
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);

}
