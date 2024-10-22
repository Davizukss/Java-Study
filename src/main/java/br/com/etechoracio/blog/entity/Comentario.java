package br.com.etechoracio.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_COMENTARIO")
public class Comentario {

	@Id
	@Column(name = "ID_COMENTARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "TX_CONTEUDO")
	private String conteudo;
	
	@Column(name = "DT_CRIACAO")
	private LocalDateTime dataCriacao;
	
	@ManyToOne
	@JoinColumn(name = "ID_POSTAGEM")
	private Postagem postagem;

	@ManyToOne
	@JoinColumn(name = "ID_AUTOR")
	private Usuario autor;

	@PrePersist
	protected void prePersist() {
		if (this.dataCriacao == null) {
			this.dataCriacao = LocalDateTime.now();
		}
	}
}
