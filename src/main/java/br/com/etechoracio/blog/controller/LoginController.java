package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.dto.LoginRequestDTO;
import br.com.etechoracio.blog.dto.LoginResponseDTO;
import br.com.etechoracio.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponseDTO> autenticar(@RequestBody LoginRequestDTO request) {
        var token = loginService.autenticar(request);
        return ResponseEntity.ok(token);
    }

}
