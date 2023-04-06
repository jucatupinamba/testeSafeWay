package com.ecommerce.safeWay.controller;

import com.ecommerce.safeWay.repository.entities.Produto;
import com.ecommerce.safeWay.repository.entities.Usuario;
import com.ecommerce.safeWay.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class VendasController {
    @Autowired
    private VendasService vendasService;

    @PostMapping(value = "/addProduto{id}")
    public ResponseEntity<List<Produto>>addProduto(Long id, Produto addNovoProduto){
        vendasService.addProduto(id, addNovoProduto);
        return ResponseEntity.ok(Collections.singletonList(addNovoProduto));
    }
    @PostMapping(value = "/fecharVenda")
    public ResponseEntity<Object> fecharVenda(List<Produto> totalProdutos){
        vendasService.fecharVenda(totalProdutos);
        return ResponseEntity.ok(Collections.singletonList(totalProdutos));
    }
    @GetMapping("/vendasTotais")
    public ResponseEntity<List<Object>> vendasTotais(List<Object> totalVendas){
        Object vendas = vendasService.relatorioVendas(totalVendas);
        return ResponseEntity.ok(Collections.singletonList(vendas));
    }
}
