package br.com.etechoracio.blog.service;

import br.com.etechoracio.blog.dto.ComentarioInsercaoDTO;
import br.com.etechoracio.blog.dto.ComentarioResponseDTO;
import br.com.etechoracio.blog.entity.Comentario;
import br.com.etechoracio.blog.mapper.ModelMapperCustom;
import br.com.etechoracio.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ModelMapperCustom mapper;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public ComentarioResponseDTO inserir(ComentarioInsercaoDTO comentario) {
        var insert = mapper.map(comentario, Comentario.class);
        return mapper.map(comentarioRepository.save(insert), ComentarioResponseDTO.class);
    }

}
