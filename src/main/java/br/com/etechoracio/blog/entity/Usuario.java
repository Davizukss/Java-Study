package br.com.etechoracio.blog.entity;

import br.com.etechoracio.blog.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_LOGIN")
    private String login;

    @Column(name = "TX_SENHA")
    private String senha;

    @Column(name = "TX_ROLE")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
