package com.auth.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.auth.jwt.model.Usuario;
import com.auth.jwt.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo ;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepo.save(usuario) ;
    }

    @Override
    public void eliminarUsuario(int idUsuario) {

        Optional<Usuario> usuario = usuarioRepo.findById(idUsuario);

        if(usuario.isPresent()) {
            usuarioRepo.delete(usuario.get());
        }else {}
    }

    @Override
    public Usuario editarUsuario(int idUsuario) {
        Optional<Usuario> usuario =  usuarioRepo.findById(idUsuario);
        return usuario.get();
    }
}
