package br.com.etechoracio.blog.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String usuario;
    private String senha;

}
