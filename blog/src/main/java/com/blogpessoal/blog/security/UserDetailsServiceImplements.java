package com.blogpessoal.blog.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogpessoal.blog.modelos.Usuario;
import com.blogpessoal.blog.repositorio.UsuarioRepositorio;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio repositorio;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> objetoOptional = repositorio.findByEmail(userName);
		
		if (objetoOptional.isPresent()) {
			return new UserDetailsImplements(objetoOptional.get());			
		} else {
			throw new UsernameNotFoundException(userName + "Não existe!");
		}
	}
	
}
