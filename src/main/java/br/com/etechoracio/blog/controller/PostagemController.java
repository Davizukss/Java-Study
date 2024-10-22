package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.dto.PostagemInsercaoDTO;
import br.com.etechoracio.blog.dto.PostagemResponseDTO;
import br.com.etechoracio.blog.dto.UsuarioInsercaoDTO;
import br.com.etechoracio.blog.dto.UsuarioResponseDTO;
import br.com.etechoracio.blog.service.PostagemService;
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
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @PostMapping
    public ResponseEntity<PostagemResponseDTO> inserir(@RequestBody PostagemInsercaoDTO body) {
        log.info("> Inserção de postagem => {}", body);
        var inserida = postagemService.inserir(body);
        log.info("> Postagem inserida com sucesso => {}", inserida);
        return ResponseEntity.ok(inserida);
    }

}
