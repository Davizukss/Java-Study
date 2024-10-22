package br.com.etechoracio.blog.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class PostagemResponseDTO {

    private Integer id;
    private String titulo;
    private String conteudo;
    private LocalDateTime dataCriacao;
    private IdDTO autor;

}
