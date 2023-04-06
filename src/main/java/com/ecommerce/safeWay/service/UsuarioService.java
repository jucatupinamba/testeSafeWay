package com.ecommerce.safeWay.service;

import com.ecommerce.safeWay.repository.UsuarioRepository;
import com.ecommerce.safeWay.repository.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario create(Usuario usuarioForm){

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioForm.getNome());
        usuario.setCpf(usuarioForm.getCpf());
        usuario.setEmail(usuarioForm.getEmail());
        usuario.setEndereco(usuarioForm.getEndereco());

        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElse(null);}

    public Usuario update(Long id, Usuario usuarioAtual) {
        Usuario newObj = findById(id);
        newObj.setNome(usuarioAtual.getNome());
        newObj.setEmail(usuarioAtual.getEmail());
        newObj.setEndereco(usuarioAtual.getEndereco());

        return usuarioRepository.save(newObj);
    }

    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public List<Usuario> findAll(Usuario usuario) {
        List<Usuario> todosOsClientes = usuarioRepository.findAll();
        return todosOsClientes;
    }
}
