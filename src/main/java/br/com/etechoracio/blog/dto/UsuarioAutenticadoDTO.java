package br.com.etechoracio.blog.dto;

import br.com.etechoracio.blog.entity.Usuario;
import br.com.etechoracio.blog.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAutenticadoDTO {

    private Integer id;
    private String nome;
    private String login;
    private String senha;
    private RoleEnum role;

    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return usuario;
    }

}
