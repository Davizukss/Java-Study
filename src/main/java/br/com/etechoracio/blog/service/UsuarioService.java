package br.com.etechoracio.blog.service;

import br.com.etechoracio.blog.dto.UsuarioInsercaoDTO;
import br.com.etechoracio.blog.dto.UsuarioResponseDTO;
import br.com.etechoracio.blog.entity.Usuario;
import br.com.etechoracio.blog.mapper.ModelMapperCustom;
import br.com.etechoracio.blog.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private ModelMapperCustom mapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UsuarioResponseDTO inserir(UsuarioInsercaoDTO usuario) {
        var insert = mapper.map(usuario, Usuario.class);
        var senhaCifrada = passwordEncoder.encode(usuario.getSenha());
        log.info("Senha cifrada => {}", senhaCifrada);
        insert.setSenha(senhaCifrada);
        return mapper.map(usuarioRepository.save(insert), UsuarioResponseDTO.class);
    }

}
