package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.dto.UsuarioInsercaoDTO;
import br.com.etechoracio.blog.dto.UsuarioResponseDTO;
import br.com.etechoracio.blog.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> inserir(@RequestBody UsuarioInsercaoDTO body) {
        log.info("> Inserção de usuário => {}", body);
        var inserido = usuarioService.inserir(body);
        log.info("> Usuário inserido com sucesso => {}", inserido);
        return ResponseEntity.ok(inserido);
    }

}
