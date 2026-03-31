package com.example.usuario.crud.controller;


import com.example.usuario.crud.entitys.Usuario;
import com.example.usuario.crud.service.Usuario.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuario(){
        return usuarioService.listarUsuario();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarPorId(@PathVariable UUID id){
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/usuarios/{id}")
        public Usuario atualizar(@PathVariable UUID id, @RequestBody Usuario usuario){
        return usuarioService.atualizarUsario(id, usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deletarUsuarioPorId(@PathVariable UUID id){
         usuarioService.deletarUsuario(id);
    }


}
