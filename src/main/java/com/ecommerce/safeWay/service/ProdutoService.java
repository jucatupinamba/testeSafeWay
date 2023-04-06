package com.ecommerce.safeWay.service;

import com.ecommerce.safeWay.repository.ProdutoRepository;
import com.ecommerce.safeWay.repository.entities.Produto;
import com.ecommerce.safeWay.repository.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto create(Produto produtoForm){
        Produto produto = new Produto();

        produto.setNome(produtoForm.getNome());
        produto.setPreco(produtoForm.getPreco());
        produto.setQuantidade(produtoForm.getQuantidade());

        return produtoRepository.save(produto);
    }

    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElse(null);}

    public Produto update( Long id, Produto produtoAtual){
        Produto newObj = findById(id);
        newObj.setNome(produtoAtual.getNome());
        newObj.setPreco(produtoAtual.getPreco());
        newObj.setQuantidade(produtoAtual.getQuantidade());

        return produtoRepository.save(newObj);

    }

    public List<Produto> buscarTodos(Produto produto) {
        List<Produto> todosProdutos = produtoRepository.findAll();
        return todosProdutos;
    }

    public Produto apagar(Produto produto) {
        produtoRepository.delete(produto);
        return produto;
    }
}
