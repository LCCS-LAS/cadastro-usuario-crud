package com.example.usuario.crud.service.Usuario;

import com.example.usuario.crud.entitys.Usuario;
import com.example.usuario.crud.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private  final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(UUID id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public void deletarUsuario(UUID id){
         usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsario(UUID id, Usuario usuario){
        Usuario usuarioExistente = buscarPorId(id);
        usuarioExistente.setNome(usuario.getNome());
        return usuarioRepository.save(usuarioExistente);
    }

}
