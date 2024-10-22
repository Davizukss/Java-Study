package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.dto.ComentarioInsercaoDTO;
import br.com.etechoracio.blog.dto.ComentarioResponseDTO;
import br.com.etechoracio.blog.service.ComentarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<ComentarioResponseDTO> inserir(@RequestBody ComentarioInsercaoDTO body) {
        log.info("> Inserção de comentario => {}", body);
        var inserida = comentarioService.inserir(body);
        log.info("> Comentario inserido com sucesso => {}", inserida);
        return ResponseEntity.ok(inserida);
    }

}
