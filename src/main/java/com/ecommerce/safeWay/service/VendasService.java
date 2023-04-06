package com.ecommerce.safeWay.service;

import com.ecommerce.safeWay.repository.ProdutoRepository;
import com.ecommerce.safeWay.repository.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VendasService {

    private Set<Produto> listaProdutos = new HashSet<>();
    private List<Object> totalVendas;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;

    public boolean addProduto(Long id, Produto produto){

        Produto newObj = produtoService.findById(id);

        if(newObj != null){
           listaProdutos.add(produto);
           return true;
        }else{
           return false;
        }
    }

    public List<Object> fecharVenda(List<Produto> carrinho){
        carrinho = new ArrayList<>(listaProdutos);
        totalVendas.add(carrinho);

        return Collections.singletonList(carrinho);
    }

    public List<Object> relatorioVendas(List<Object> relatorio){

         for(Object listaCarrinho : totalVendas){
             System.out.println("Novo Carrinho: ");
            for(Object listaProduto : listaProdutos){
                System.out.println(listaProduto);
            }
        }
        return relatorio;
    }

}
