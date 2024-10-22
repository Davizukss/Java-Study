package br.com.etechoracio.blog.service;

import br.com.etechoracio.blog.dto.PostagemInsercaoDTO;
import br.com.etechoracio.blog.dto.PostagemResponseDTO;
import br.com.etechoracio.blog.entity.Postagem;
import br.com.etechoracio.blog.mapper.ModelMapperCustom;
import br.com.etechoracio.blog.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {

    @Autowired
    private ModelMapperCustom mapper;

    @Autowired
    private PostagemRepository postagemRepository;

    public PostagemResponseDTO inserir(PostagemInsercaoDTO postagem) {
        var insert = mapper.map(postagem, Postagem.class);
        return mapper.map(postagemRepository.save(insert), PostagemResponseDTO.class);
    }

}
