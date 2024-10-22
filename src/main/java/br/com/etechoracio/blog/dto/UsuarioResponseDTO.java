package br.com.etechoracio.blog.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioResponseDTO {

    private Integer id;
    private String nome;
    private String login;

}
