package com.ecommerce.safeWay.controller;


import com.ecommerce.safeWay.repository.entities.Produto;
import com.ecommerce.safeWay.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @PostMapping(value = "/createProduct")
    public ResponseEntity<Produto> criar(Produto produto){
        Produto criarProduto = produtoService.create(produto);
        return ResponseEntity.ok(criarProduto);
    }

    @PutMapping("/produto{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto){
        Produto produtoExistente = produtoService.findById(id);

        if(produtoExistente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(produto, produtoExistente, "id");

        return ResponseEntity.ok(produtoService.update(id, produto));

    }

    @DeleteMapping("/deleteProduct{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Produto produto = produtoService.findById(id);
        if(produto == null){
            return ResponseEntity.notFound().build();
        }
        produtoService.delete(produto);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Produto>> buscarTodos(@Valid @RequestBody Produto produto){
        List<Produto> todosProdutos = produtoService.findAll(produto);
        return ResponseEntity.ok(todosProdutos);
    }

    @GetMapping("/buscarProduto{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto){
        Produto produtoExistente = produtoService.findById(id);

        if(produtoExistente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(produto, produtoExistente, "id");

        return ResponseEntity.ok(produtoExistente);
    }
}

