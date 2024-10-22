package br.com.etechoracio.blog.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //@Autowired
    //private JwtToken jwtToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //var token = getToken(request);
        //if (token.isEmpty()) {
        //    filterChain.doFilter(request, response);
        //    return;
        //}

        //var userDetails = jwtToken.getUsuarioAutenticado(token.get());

        //var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        //authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        //SecurityContext context = SecurityContextHolder.createEmptyContext();
        //context.setAuthentication(authToken);
        //SecurityContextHolder.setContext(context);

        filterChain.doFilter(request, response);
    }

    private Optional<String> getToken(HttpServletRequest request) {
        var token = request.getHeader(HttpHeaders.AUTHORIZATION);
        return token == null || token.isEmpty() ? Optional.empty()
                                                : Optional.of(token);
    }


}
