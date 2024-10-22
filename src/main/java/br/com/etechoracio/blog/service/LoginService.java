package br.com.etechoracio.blog.service;

import br.com.etechoracio.blog.dto.LoginRequestDTO;
import br.com.etechoracio.blog.dto.LoginResponseDTO;
import br.com.etechoracio.blog.dto.UsuarioAutenticadoDTO;
import br.com.etechoracio.blog.enums.RoleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {


    public LoginResponseDTO autenticar(LoginRequestDTO request) {
        return LoginResponseDTO.builder().token(UUID.randomUUID().toString()).build();
    }


    private UsuarioAutenticadoDTO mockAutenticado() {
        return UsuarioAutenticadoDTO.builder().id(1)
                                              .nome("Horácio Augusto")
                                              .login("admin")
                                              .senha("123456")
                                              .role(RoleEnum.CRIADOR)
                                    .build();
    }

}
