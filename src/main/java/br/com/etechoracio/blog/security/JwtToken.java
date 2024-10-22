package br.com.etechoracio.blog.security;

import br.com.etechoracio.blog.dto.UsuarioAutenticadoDTO;
import br.com.etechoracio.blog.enums.RoleEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@Component
public class JwtToken {

    @Value("${token.security.key}")
    private String jwtSecurityKey;

    @Value("${token.security.expiration-time}")
    private Duration jwtExpirationTime;

    private Key getChaveAssinatura() {
        return Keys.hmacShaKeyFor(jwtSecurityKey.getBytes());
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getChaveAssinatura())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String gerar(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", ((UsuarioAutenticadoDTO)userDetails).getRole())
               .claim("id", ((UsuarioAutenticadoDTO)userDetails).getId())
               .claim("nome", ((UsuarioAutenticadoDTO)userDetails).getNome())
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationTime.toMillis()))
               .signWith(getChaveAssinatura(), SignatureAlgorithm.HS256)
               .compact();
   }

    @SuppressWarnings("unchecked")
    public UserDetails getUsuarioAutenticado(String token) {
        var claims = getClaims(token);
        var role = claims.get("roles", List.class).stream().findAny().orElse(RoleEnum.COMENTADOR.name());
        return (UserDetails) UsuarioAutenticadoDTO.builder().login(claims.getSubject())
                                              .id(claims.get("id", Integer.class))
                                              .role(RoleEnum.getByValue((String) role))
                                    .build();
    }

}
