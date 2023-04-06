package com.ecommerce.safeWay.controller;

import com.ecommerce.safeWay.repository.entities.Usuario;
import com.ecommerce.safeWay.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/createUser")
    public ResponseEntity<Usuario> criar( Usuario usuario){
        Usuario criarUsuario = usuarioService.create(usuario);
        return ResponseEntity.ok(criarUsuario);
    }

    @PutMapping("/user{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario){
        Usuario usuarioExistente = usuarioService.findById(id);

        if(usuarioExistente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(usuario, usuarioExistente, "id");

        return ResponseEntity.ok(usuarioService.update(id, usuario));

    }

    @DeleteMapping("/deleteUser{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        usuarioService.delete(usuario);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<Usuario>> buscarTodos(@Valid @RequestBody Usuario usuario){
        List<Usuario> todosUsuarios = usuarioService.findAll(usuario);
        return ResponseEntity.ok(todosUsuarios);
    }

    @GetMapping("/buscarUser{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuario){
        Usuario usuarioExistente = usuarioService.findById(id);

        if(usuarioExistente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(usuario, usuarioExistente, "id");

        return ResponseEntity.ok(usuarioExistente);
    }
}
