package com.auth.jwt.service;
import com.auth.jwt.model.Usuario;
import java.util.List;

public interface IUsuarioService {

    List<Usuario> listarUsuarios();
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(int idUsuario) ;
    Usuario editarUsuario(int idUsuario) ;

}
