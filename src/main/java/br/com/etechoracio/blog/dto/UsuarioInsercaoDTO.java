package br.com.etechoracio.blog.dto;

import br.com.etechoracio.blog.enums.RoleEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioInsercaoDTO {

    private String nome;
    private String login;
    private String senha;
    private RoleEnum role;

}
