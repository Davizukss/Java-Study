package br.com.etechoracio.blog.security;

public class UsuarioAutenticadoHolder {

    //public static Optional<UsuarioAutenticadoDTO> get() {
    //    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //    Object principal = authentication.getPrincipal();
    //    if (principal instanceof UsuarioAutenticadoDTO) {
    //        return Optional.of((UsuarioAutenticadoDTO) principal);
    //    } else {
    //        return Optional.empty();
    //    }
    //}

    //public static Usuario getUsuario() {
    //    return get().map(UsuarioAutenticadoDTO::toUsuario).orElse(null);
    //}

}
