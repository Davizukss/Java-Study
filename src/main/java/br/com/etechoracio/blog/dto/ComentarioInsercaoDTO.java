package br.com.etechoracio.blog.dto;

import lombok.Data;

@Data
public class ComentarioInsercaoDTO {

    private String conteudo;
    private IdDTO postagem;

}
