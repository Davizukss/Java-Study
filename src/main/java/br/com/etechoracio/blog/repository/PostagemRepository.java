package br.com.etechoracio.blog.repository;

import br.com.etechoracio.blog.entity.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
}
