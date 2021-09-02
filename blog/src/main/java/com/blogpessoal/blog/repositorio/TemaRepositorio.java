package com.blogpessoal.blog.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.blog.modelos.Tema;

@Repository
public interface TemaRepositorio extends JpaRepository<Tema, Long>{

}
