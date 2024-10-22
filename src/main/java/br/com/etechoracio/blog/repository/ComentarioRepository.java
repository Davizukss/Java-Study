package br.com.etechoracio.blog.repository;

import br.com.etechoracio.blog.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
