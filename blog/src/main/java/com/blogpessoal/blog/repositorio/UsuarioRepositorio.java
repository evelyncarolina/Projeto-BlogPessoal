package com.blogpessoal.blog.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.blog.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	/**
	 * Método utilizado para pesquisar coluna nome ContainigIgnoreCase
	 * 
	 * @param nome do tipo String
	 * @return List de Usuarios
	 * @author Evelyn
	 * @since 1.0
	 * 
	 */
	
	//findAllBy: Faz uma pesquisa
	//Containing: Pesquisa letras letras independente mas de forma ordenada
	//IgnoreCase: as letras podem ser minusculas ou maiusculas 
	
	List<Usuario>  findAllByNomeContainingIgnoreCase(String nome);
	
	/**
	 * Método utilizado para pesquisar coluna email
	 * 
	 * @param email do tipo String
	 * @return Optional com Usuario
	 * @author Evelyn
	 * @since 1.0
	 * 
	 */
	
	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByUsuario(String userName);


}



