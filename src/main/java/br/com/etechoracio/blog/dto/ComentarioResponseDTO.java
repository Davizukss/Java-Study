package br.com.etechoracio.blog.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ComentarioResponseDTO {

    private Integer id;
    private String conteudo;
    private LocalDateTime dataCriacao;
    private IdDTO autor;

}
